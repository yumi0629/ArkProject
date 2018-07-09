@file:JvmMultifileClass
@file:JvmName("JsonUtil")

package com.shendx.ark.base.lib.util.json

import com.google.gson.Gson
import com.shendx.ark.base.lib.util.loge

fun Any.toJson(): String {
    var jsonStr = ""
    try {
        jsonStr = Gson().toJson(this) //现在替换为Gson
    } catch (e: Exception) {
        loge(e)
    }
    return jsonStr
}

infix fun <T> String.parseJson(parseClass: Class<T>): T? {
    var t: T? = null
    try {
        t = Gson().fromJson(this, parseClass) //现在替换为Gson
    } catch (e: Exception) {
        loge(e)
    }
    return t
}

infix fun <T> String.parseJsonArray(parseClass: Class<T>): MutableList<T>? {
    var t: MutableList<T>? = null
    try {
        val listType = ParameterizedTypeImpl(MutableList::class.java, arrayOf(parseClass)) //现在替换为Gson
        t = Gson().fromJson(this, listType)
    } catch (e: Exception) {
        loge(e)
    }
    return t
}

fun Any.toMap(): Map<*, *> {
    return this.toJson().parseJson(Map::class.java) as Map<*, *>
}