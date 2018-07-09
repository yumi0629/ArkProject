@file:JvmMultifileClass
@file:JvmName("LogUtil")
@file:Suppress("unused")

package com.shendx.ark.base.lib.util

import android.util.Log
import com.orhanobut.logger.*
import com.shendx.ark.base.lib.util.json.toJson

private var init = false
private var isAndroid = false
private var isDebugMode = false

fun initLogUtil(isDebug: Boolean, tag: String) {
    if (!init) {
        init = true
        isAndroid = true
        isDebugMode = isDebug
        val formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(2)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(LogCatStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build()
        Logger.addLogAdapter(MyAndroidLogAdapter(formatStrategy, isDebug))
    }
}

private class LogCatStrategy : LogStrategy {

    private var last: Int = 0

    override fun log(priority: Int, tag: String?, message: String) {
        Log.println(priority, randomKey() + tag!!, message)
    }

    private fun randomKey(): String {
        var random = (10 * Math.random()).toInt()
        if (random == last) {
            random = (random + 1) % 10
        }
        last = random
        return random.toString()
    }
}

private class MyAndroidLogAdapter(formatStrategy: FormatStrategy, val isDebug: Boolean) :
        AndroidLogAdapter(formatStrategy) {
    override fun isLoggable(priority: Int, tag: String?): Boolean = isDebug
}

fun logv(message: String) {
    if (isAndroid) {
        Logger.v(message)
    } else {
        println(message)
    }
}

fun logv(obj: Any?) {
    if (isAndroid) {
        Logger.v(obj?.toString() ?: "null")
    } else {
        println(obj)
    }
}

fun logv(tag: String, message: String) {
    if (isAndroid) {
        Logger.t(tag).v(message)
    } else {
        println(message)
    }
}

fun logi(message: String) {
    if (isAndroid) {
        Logger.i(message)
    } else {
        println(message)
    }
}

fun logi(obj: Any?) {
    if (isAndroid) {
        Logger.i(obj?.toString() ?: "null")
    } else {
        println(obj)
    }
}

fun logi(tag: String, message: String) {
    if (isAndroid) {
        Logger.t(tag).i(message)
    } else {
        println(message)
    }
}


fun logw(message: String) {
    if (isAndroid) {
        Logger.w(message)
    } else {
        println(message)
    }
}

fun logd(objs: Any?) {
    if (isAndroid) {
        Logger.d(objs)
    } else {
        println(objs)
    }
}

fun logd(tag: String, obj: Any? = null) {
    if (isAndroid) {
        Logger.t(tag).d(obj)
    } else {
        println(obj)
    }
}


fun logd(message: String) {
    if (isAndroid) {
        Logger.d(message)
    } else {
        println(message)
    }
}

fun logw(obj: Any?) {
    if (isAndroid) {
        Logger.w(obj?.toString() ?: "null")
    } else {
        println(obj)
    }
}

fun logw(tag: String, message: String) {
    if (isAndroid) {
        Logger.t(tag).w(message)
    } else {
        println(message)
    }
}

fun loge(message: String) {
    if (isAndroid) {
        Logger.e(message)
    } else {
        System.err.println(message)
    }
}

fun loge(obj: Any?) {
    if (isAndroid) {
        Logger.e(obj?.toString() ?: "null")
    } else {
        println(obj)
    }
}

fun loge(tag: String, obj: Any? = null) {
    if (isAndroid) {
        Logger.t(tag).e(obj?.toString() ?: "null")
    } else {
        System.err.println(obj)
    }
}

fun loge(tag: String, e: Exception) {
    if (isAndroid) {
        if (isDebugMode) {
            Logger.e(tag, e, e.message, "")
        } else {
            e.printStackTrace()
            // todo 此处应该上传服务器
        }
    } else {
        System.err.println(e.message)
    }
}

fun loge(e: Exception) {
    if (isAndroid) {
        if (isDebugMode) {
            Logger.e(e, e.message ?: "", "")
        } else {
            e.printStackTrace()
            // todo 此处应该上传服务器
        }
    } else {
        System.err.println(e.message)
    }
}

fun logAssert(message: String) {
    if (isAndroid) {
        Logger.wtf(message)
    } else {
        System.err.println(message)
    }
}

fun logAssert(obj: Any?) {
    if (isAndroid) {
        Logger.wtf(obj?.toString() ?: "null")
    } else {
        println(obj)
    }
}

fun logAssert(tag: String, message: String) {
    if (isAndroid) {
        Logger.t(tag).wtf(message)
    } else {
        System.err.println(message)
    }
}

fun logJson(json: String?) {
    if (isAndroid) {
        Logger.json(json)
    } else {
        println(json)
    }
}

fun logJson(any: Any?) {
    if (isAndroid) {
        Logger.json(any?.toJson())
    } else {
        println(any)
    }
}

fun logJson(tag: String, json: String?) {
    if (isAndroid) {
        Logger.t(tag).json(json)
    } else {
        println(json)
    }
}

fun logJson(tag: String, any: Any?) {
    if (isAndroid) {
        Logger.t(tag).json(any?.toJson())
    } else {
        println(any)
    }
}

fun logXml(xml: String?) {
    if (isAndroid) {
        Logger.xml(xml)
    } else {
        println(xml)
    }
}
