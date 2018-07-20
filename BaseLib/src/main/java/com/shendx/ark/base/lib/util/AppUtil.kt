package com.shendx.ark.base.lib.util

import android.util.TypedValue
import com.shendx.ark.base.lib.BaseApplication

object AppUtil {
    fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
                BaseApplication.context.resources.displayMetrics).toInt()
    }
}