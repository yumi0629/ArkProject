package com.shendx.ark.ym.ui.widget.toolbar

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.app.FragmentActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.shendx.ark.base.lib.util.getAttrColor
import com.shendx.ark.ym.ui.R
import kotlinx.android.synthetic.main.ym_toolbar_view.view.*

/**
 * PS:
 * Created by sdx on 2018/11/30.
 */
class YMToolBar(context: Context, attrs: AttributeSet?, defStyle: Int)
    : ConstraintLayout(context, attrs, defStyle)
        , View.OnClickListener {
    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private var titleStr = ""

    private var hideLeft = false

    init {
        initAttrs(attrs)

        setBackgroundColor(getAttrColor(context, R.attr.ym_common_color_theme))

        LayoutInflater.from(context).inflate(R.layout.ym_toolbar_view, this)
        initView()
    }

    private fun initAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.YMToolBar)
            titleStr = a.getString(R.styleable.YMToolBar_ym_toolbar_title) ?: ""
            hideLeft = a.getBoolean(R.styleable.YMToolBar_ym_toolbar_hideLeft, false)
            a.recycle()
        }
    }

    private fun initView() {
        initTitle()
    }

    private fun initTitle() {
        if (hideLeft) {
            tv_back.visibility = View.GONE
        } else {
            tv_back.setOnClickListener {
                (context as? FragmentActivity)?.finish()
            }
        }

        tv_title.text = titleStr
    }

    override fun onClick(v: View) {

    }
}
