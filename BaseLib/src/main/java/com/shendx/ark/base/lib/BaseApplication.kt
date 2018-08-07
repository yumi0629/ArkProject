package com.shendx.ark.base.lib

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
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
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        initBaseApplication()
    }

    private fun initBaseApplication() {
        initARouter()
        initLogUtil(true, "Ark")
        loge("initBaseApplication")
    }

    private fun initARouter() {
        ARouter.openLog()    // 打印日志
        ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(context) // 尽可能早，推荐在Application中初始化
    }
}