package com.shendx.ark.base.lib.util.delegate

import android.content.Context
import android.content.SharedPreferences
import com.shendx.ark.base.lib.BaseApplication
import java.io.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 */
class SharedPreferenceUtil<T>(private val key: String,
                              private val default: T,
                              private val name: String)
    : ReadWriteProperty<Any?, T> {

    companion object {
        fun clear(name: String, key: String) {
            sharedPreferences(name).edit().remove(key).apply()
        }

        fun clear(name: String) {
            sharedPreferences(name).edit().clear().apply()
        }

        private fun sharedPreferences(name: String): SharedPreferences {
            return BaseApplication.context.getSharedPreferences(name, Context.MODE_PRIVATE)
        }
    }

    private val preference: SharedPreferences by lazy {
        BaseApplication.context.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = findPreference(key, default)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putPreference(key, value)

    /**
     * 查找数据 返回给调用方法一个具体的对象
     * 如果查找不到类型就采用反序列化方法来返回类型
     * default是默认对象 以防止会返回空对象的异常
     * 即如果name没有查找到value 就返回默认的序列化对象，然后经过反序列化返回
     */
    private fun <A> findPreference(name: String, default: A): A = with(preference) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> deSerialization(getString(name, serialize(default)))
        }
        res as A
    }

    private fun <A> putPreference(name: String, value: A) = with(preference.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> putString(name, serialize(value))
        }.apply()

    }

    /**
     * 序列化对象
     */
    @Throws(IOException::class)
    private fun <A> serialize(obj: A): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var serStr = byteArrayOutputStream.toString("ISO-8859-1")
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return serStr
    }

    /**
     * 反序列化对象
     */
    @Throws(IOException::class, ClassNotFoundException::class)
    private fun <A> deSerialization(str: String): A {
        val redStr = java.net.URLDecoder.decode(str, "UTF-8")
        val byteArrayInputStream = ByteArrayInputStream(
                redStr.toByteArray(charset("ISO-8859-1")))
        val objectInputStream = ObjectInputStream(
                byteArrayInputStream)
        val obj = objectInputStream.readObject() as A
        objectInputStream.close()
        byteArrayInputStream.close()
        return obj
    }
}