package com.shendx.ark

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.shendx.ark.base.lib.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getTitleText(): Int? = R.string.base_app_name

    override fun bindView(savedInstanceState: Bundle?) {
        button.setOnClickListener {
            ARouter.getInstance().build("/m_wan/MainActivity").navigation()
        }
    }

    override fun initData() {
    }
}
