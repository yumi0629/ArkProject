package com.shendx.ark

import com.shendx.ark.base.lib.BaseApplication
import com.shendx.ark.base.lib.util.loge
import com.squareup.leakcanary.LeakCanary

/**
 * PS:
 * Created by sdx on 2018/7/6.
 */
class ArkApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        loge("ArkApplication")
        BaseApplication.initBaseApplication()
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