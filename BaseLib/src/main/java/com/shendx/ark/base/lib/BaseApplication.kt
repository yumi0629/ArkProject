package com.shendx.ark.base.lib

import android.content.Context
import android.support.multidex.MultiDexApplication
import kotlin.properties.Delegates

/**
 * PS:
 * Created by sdx on 2018/7/6.
 */
open class BaseApplication : MultiDexApplication() {

    companion object {
        @JvmStatic
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}