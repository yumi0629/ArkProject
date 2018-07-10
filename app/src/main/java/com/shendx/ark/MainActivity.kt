package com.shendx.ark

import android.os.Bundle
import com.shendx.ark.base.lib.ui.BaseActivity
import com.shendx.ark.example.module.ExampleModuleTest

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            ExampleModuleTest.log()
        } catch (e:Exception){}
    }
}
