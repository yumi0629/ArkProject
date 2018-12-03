package com.shendx.ark.demo.ymui

import android.content.Intent
import android.os.Bundle
import com.shendx.ark.ym.ui.widget.BaseActivity

/**
 *
 */
class MainActivity : BaseActivity() {
    companion object {
        fun start(activity: BaseActivity) {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun bindView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

}
