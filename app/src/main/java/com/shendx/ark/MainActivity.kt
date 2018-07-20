package com.shendx.ark

import android.os.Bundle
import com.shendx.ark.base.lib.ui.BaseActivity

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getTitleText(): Int? = R.string.base_app_name

    override fun bindView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
