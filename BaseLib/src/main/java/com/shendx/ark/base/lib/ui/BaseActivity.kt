package com.shendx.ark.base.lib.ui

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.shendx.ark.base.lib.R
import com.shendx.ark.base.lib.util.getStringRes
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


/**
 * PS:
 * Created by sdx on 2018/7/9.
 */
abstract class BaseActivity : RxAppCompatActivity() {

    val toolbar: Toolbar? by lazy { findViewById<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        setStatusBar()
        initExtraData()
        initToolBar()
        bindView(savedInstanceState)
        initData() //为onCreate最后一个方法
    }

    protected fun setStatusBar() {
    }

    /**
     * 界面展示所用的布局文件
     */
    @LayoutRes
    protected abstract fun getLayoutId(): Int

    /**
     * 界面标题所用的文字
     */
    @StringRes
    protected abstract fun getTitleText(): Int?

    /**
     * 提取Intent传递的ExtraData
     */
    protected fun initExtraData() {}

    /**
     * 初始化ToolBar
     */
    private fun initToolBar() {
        toolbar?.let {
            // 主标题
            it.title = getStringRes(getTitleText()?:R.string.base_empty)
            //设置toolbar
            setSupportActionBar(toolbar)
//            supportActionBar?.setDisplayUseLogoEnabled(true)
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            //左边的小箭头（注意需要在setSupport
            // ActionBar(toolbar)之后才有效果）
            it.setNavigationIcon(R.drawable.base_ic_back)
//            toolbar.findViewById<TextView>(R.id.toolbar_title).text = "toolbar_title"
        }
    }

    /**
     * 初始化界面
     */
    abstract fun bindView(savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    abstract fun initData()

    var titleTx
        get() = toolbar?.title ?: ""
        set(value) {
            toolbar?.title = value
        }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
