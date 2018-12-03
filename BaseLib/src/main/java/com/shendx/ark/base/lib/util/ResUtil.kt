@file:JvmMultifileClass
@file:JvmName("ResUtil")
@file:Suppress("unused")

package com.shendx.ark.base.lib.util

/**
 * Title: ResUtils
 * app资源utils
 * @author SDX
 */

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.shendx.ark.base.lib.BaseApplication

// **************************************************
//      res
// **************************************************

fun getResString(@StringRes id: Int): String {
    return BaseApplication.context.resources.getString(id)
}

fun getResStringArr(@ArrayRes id: Int): Array<String> {
    return BaseApplication.context.resources.getStringArray(id)
}

fun getResString(@StringRes id: Int, vararg formatArgs: Any): String {
    return BaseApplication.context.resources.getString(id, *formatArgs)
}

fun getResColor(@ColorRes id: Int): Int {
    return ContextCompat.getColor(BaseApplication.context, id)
}

/**
 * 如果单位是dp或sp，则需要将其乘以density 如果是px，则不乘
 */
fun getResDimension(@DimenRes id: Int): Float {
    return BaseApplication.context.resources.getDimension(id)
}

/**
 * 如果单位是dp或sp，则需要将其乘以density 如果是px，则不乘
 */
fun getResDimensionPixelOffset(@DimenRes id: Int): Int {
    return BaseApplication.context.resources.getDimensionPixelOffset(id)
}

/**
 * 不管写的是dp还是sp还是px,都会乘以density
 */
fun getResDimensionPixelSize(@DimenRes id: Int): Int {
    return BaseApplication.context.resources.getDimensionPixelSize(id)
}

fun getResDrawable(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(BaseApplication.context, id)
}

fun getResAnim(@AnimRes id: Int): Animation? {
    var animation: Animation? = null
    try {
        animation = AnimationUtils.loadAnimation(BaseApplication.context, id)
    } catch (e: Exception) {
        loge(e)
    }
    return animation
}

// **************************************************
//      dp sp px map
// **************************************************

private fun getDensity(): Float {
    return BaseApplication.context.resources.displayMetrics.density
}

private fun getFontDensity(): Float {
    return BaseApplication.context.resources.displayMetrics.scaledDensity
}

/**
 * 单位转换: dp -> px
 */
fun dp2px(dp: Int): Int {
    return (getDensity() * dp + 0.5).toInt()
}

/**
 * 单位转换: sp -> px
 */
fun sp2px(sp: Int): Int {
    return (getFontDensity() * sp + 0.5).toInt()
}

/**
 * 单位转换:px -> dp
 */
fun px2dp(px: Int): Int {
    return (px / getDensity() + 0.5).toInt()
}

/**
 * 单位转换:px -> sp
 */
fun px2sp(px: Int): Int {
    return (px / getFontDensity() + 0.5).toInt()
}

// **************************************************
//      attrs
// **************************************************

fun getAttrFloatValue(context: Context, @AttrRes attrRes: Int): Float {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.float
}

fun getAttrColor(context: Context, @AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}

fun getAttrColorStateList(context: Context, @AttrRes attrRes: Int): ColorStateList? {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrRes, typedValue, true)
    return ContextCompat.getColorStateList(context, typedValue.resourceId)
}

//fun getAttrDrawable(context: Context, attrRes: Int): Drawable? {
//    val attrs = intArrayOf(attrRes)
//    val ta = context.obtainStyledAttributes(attrs)
//    val drawable = getAttrDrawable(context, ta, 0)
//    ta.recycle()
//    return drawable
//}
//
//fun getAttrDrawable(context: Context, typedArray: TypedArray, index: Int): Drawable? {
//    val value = typedArray.peekValue(index)
//    if (value != null) {
//        if (value.type != TypedValue.TYPE_ATTRIBUTE && value.resourceId != 0) {
//            return QMUIDrawableHelper.getVectorDrawable(context, value.resourceId)
//        }
//    }
//    return null
//}

fun getAttrDimen(context: Context, @AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(attrRes, typedValue, true)
    return TypedValue.complexToDimensionPixelSize(typedValue.data, context.resources.displayMetrics)
}