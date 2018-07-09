@file:JvmMultifileClass
@file:JvmName("ResUtil")

package com.shendx.ark.base.lib.util

import android.graphics.drawable.Drawable
import android.support.annotation.*
import android.support.v4.content.ContextCompat
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.shendx.ark.base.lib.BaseApplication

/**
 *
 * Title: ResUtils
 * app资源utils
 *
 * Description:
 *
 * @author SDX
 *
 * @date 2016年6月9日
 */

/**
 * @param id
 * @return getString 从资源文件 Values
 * @author SDX
 * @data 2016年6月12日 下午1:28:46
 */
fun getStringRes(@StringRes id: Int): String {
    return BaseApplication.context.resources.getString(id)
}


fun getStringArrRes(@ArrayRes id: Int): Array<String> {
    return BaseApplication.context.resources.getStringArray(id)
}

/**
 * @param id
 * @param formatArgs
 * @return getString 从资源文件 Values
 * @author SDX
 * @data 2016年6月12日 下午1:28:49
 */
fun getStringRes(@StringRes id: Int, vararg formatArgs: Any): String {
    return BaseApplication.context.resources.getString(id, *formatArgs)
}

/**
 * @param id
 * @return 从资源文件 color
 * @author SDX
 * @data 2016年6月23日 上午10:34:07
 */
fun getColorRes(@ColorRes id: Int): Int {
    return ContextCompat.getColor(BaseApplication.context, id)
}

/**
 * 获取某个dimen的值，但是如果单位是dp或sp，则需要将其乘以density 如果是px，则不乘
 * @param id
 * @return 从资源文件 color
 * @author SDX
 */
fun getDimensionRes(@DimenRes id: Int): Float {
    return BaseApplication.context.resources.getDimension(id)
}

/**
 * 获取某个dimen的值，但是如果单位是dp或sp，则需要将其乘以density 如果是px，则不乘
 * @param id
 * @return 从资源文件 color
 * @author SDX
 */
fun getDimensionPixelOffsetRes(@DimenRes id: Int): Int {
    return BaseApplication.context.resources.getDimensionPixelOffset(id)
}

/**
 * 不管写的是dp还是sp还是px,都会乘以denstiy
 * @param id
 * @return 从资源文件 color
 * @author SDX
 */
fun getDimensionPixelSizeRes(@DimenRes id: Int): Int {
    return BaseApplication.context.resources.getDimensionPixelSize(id)
}

/**
 * @param id
 * @return 从资源文件 Drawable
 * @author SDX
 * @data 2016年6月23日 上午10:34:07
 */
fun getDrawableRes(@DrawableRes id: Int): Drawable? {
//    BaseApplication.context.resources.getDrawable(id)
    return ContextCompat.getDrawable(BaseApplication.context, id)
}

/***
 *
 */
fun getAnimRes(@AnimRes id: Int): Animation? {
    var animation: Animation? = null
    try {
        animation = AnimationUtils.loadAnimation(BaseApplication.context, id)
    } catch (e: Exception) {
        loge(e)
    }
    return animation
}
