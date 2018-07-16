package com.shendx.ark.biz.wanandroid

import android.os.Bundle
import com.shendx.ark.base.lib.ui.BaseActivity

class MainActivity : BaseActivity() {
    override fun getTitleText(): Int? = R.string.base_app_name

    override fun getLayoutId(): Int = R.layout.m_wan_activity_main

    override fun bindView(savedInstanceState: Bundle?) {
    }

    override fun initData() {
    }
}
