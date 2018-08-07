package com.shendx.ark.biz.wanandroid

import com.shendx.ark.base.lib.BaseApplication

/**
 * PS:
 * Created by sdx on 2018/7/9.
 */
class WanAndroidApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        BaseApplication.initBaseApplication()
        initLeakCanary()
    }

    private fun initLeakCanary() {

//        if (LeakCanary.isInAnalyzerProcess(this)) {
//             This process is dedicated to LeakCanary for heap analysis.
//             You should not init your app in this process.
//            return
//        }
//        LeakCanary.install(this)
        // Normal app init code...
    }
}