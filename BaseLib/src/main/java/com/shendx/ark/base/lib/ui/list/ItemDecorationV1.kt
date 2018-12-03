package com.shendx.ark.base.lib.ui.list

/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * limitations under the License.
 */

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.ColorInt
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.shendx.ark.base.lib.R
import com.shendx.ark.base.lib.util.getResDimensionPixelSize


/**
 * This class is from the v7 samples of the Android SDK. It's not by me!
 *
 *
 * See the license above for details.
 */
class ItemDecorationV1
/**
 * @param orientation
 * @param dividerHeight
 * @param headNoDivider true  在headview下面不显示divider
 */
@JvmOverloads constructor(private val mOrientation: Int = LinearLayout.VERTICAL,
                          private val dividerHeight: Int = getResDimensionPixelSize(R.dimen.base_list_decoration),
                          @ColorInt color: Int = Default_color,
                          private val headNoDivider: Boolean = false) : RecyclerView.ItemDecoration() {

    private val dividerPaint: Paint = Paint()

    init {
        dividerPaint.color = color
    }

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        if (headNoDivider && parent.adapter is BaseQuickAdapter<*, *>) {
            val adapter = parent.adapter as BaseQuickAdapter<*, *>?
            val headerLayoutCount = adapter!!.headerLayoutCount
            if (itemPosition < headerLayoutCount) {
                return
            }
        }
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, dividerHeight)
        } else {
            outRect.set(0, 0, dividerHeight, 0)
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until childCount - 1) {
            val view = parent.getChildAt(i)
            val top = view.bottom.toFloat()
            val bottom = (view.bottom + dividerHeight).toFloat()
            c.drawRect(left.toFloat(), top, right.toFloat(), bottom, dividerPaint)
        }
    }

    companion object {

        val HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL

        val VERTICAL_LIST = LinearLayoutManager.VERTICAL

        private val Default_color = -0xf0d0b
    }
}