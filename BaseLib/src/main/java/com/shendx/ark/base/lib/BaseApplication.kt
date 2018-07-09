package com.shendx.ark.base.lib

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.squareup.leakcanary.LeakCanary
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

        initLeakCanary()
    }

    private fun initLeakCanary() {

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        // Normal app init code...
    }
}