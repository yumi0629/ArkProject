package com.shendx.ark.demo.ymui

import android.os.Bundle
import android.os.Handler
import com.shendx.ark.ym.ui.widget.BaseActivity

/**
 * 启动页
 */
class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun bindView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        Handler().postDelayed({
            MainActivity.start(this)
            finish()
        }, 1000)
    }
}
