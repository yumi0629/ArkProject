package com.shendx.ark.base.lib.util

import android.content.res.Resources
import android.util.TypedValue
import com.shendx.ark.base.lib.BaseApplication

object AppUtil {
    private fun getDensity(): Float {
        return Resources.getSystem().displayMetrics.density
    }

    private fun getFontDensity(): Float {
        return Resources.getSystem().displayMetrics.scaledDensity
    }

    fun dp2px(dp: Float): Int {
        return (getDensity() * dp + 0.5f).toInt()
    }

    fun px2dp(px: Float): Int {
        return (px / getDensity() + 0.5f).toInt()
    }

    fun sp2px(sp: Float): Int {
        return (getFontDensity() * sp + 0.5f).toInt()
    }

    fun px2sp(px: Float): Int {
        return (px / getFontDensity() + 0.5f).toInt()
    }
}