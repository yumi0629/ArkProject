package com.shendx.ark.base.lib

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.shendx.ark.base.lib.util.initLogUtil
import com.shendx.ark.base.lib.util.loge
import kotlin.properties.Delegates

/**
 * PS:
 * Created by sdx on 2018/7/6.
 */
open class BaseApplication : MultiDexApplication() {

    companion object {
        @JvmStatic
        var context: Application by Delegates.notNull()

        @JvmStatic
        fun initBaseApplication(context: Application) {
            initLogUtil(true,"Ark")
            loge("initBaseApplication")
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this

    }
}