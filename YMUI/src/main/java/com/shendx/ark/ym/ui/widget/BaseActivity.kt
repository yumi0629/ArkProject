package com.shendx.ark.ym.ui.widget

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.jaeger.library.StatusBarUtil
import com.shendx.ark.base.lib.util.getAttrColor
import com.shendx.ark.ym.ui.R
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


/**
 * PS:
 * Created by sdx on 2018/7/9.
 */
abstract class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setStatusBar()
        initExtraData()
        bindView(savedInstanceState)
        initData() //为onCreate最后一个方法
    }

    protected fun setStatusBar() {
        StatusBarUtil.setColorNoTranslucent(this, getAttrColor(this, R.attr.ym_common_color_theme))
    }

    /**
     * 界面展示所用的布局文件
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 提取Intent传递的ExtraData
     */
    protected fun initExtraData() {}

    /**
     * 初始化ToolBar
     */

    /**
     * 初始化界面
     */
    abstract fun bindView(savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    abstract fun initData()
}
