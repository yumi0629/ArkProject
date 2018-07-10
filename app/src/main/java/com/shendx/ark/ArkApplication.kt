package com.shendx.ark

import com.shendx.ark.base.lib.BaseApplication
import com.shendx.ark.base.lib.util.loge

/**
 * PS:
 * Created by sdx on 2018/7/6.
 */
class ArkApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        loge("ArkApplication")
        BaseApplication.initBaseApplication(context)
    }
}