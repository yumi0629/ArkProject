@file:JvmMultifileClass
@file:JvmName("ImageViewUtil")

package com.shendx.ark.base.lib.util.img

import android.content.Context
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import java.io.File

/**
 * http://www.jianshu.com/p/c9efd313e79e
 */

private fun getGlide(context: Context): RequestManager {
//    when (context) {
//        is Activity -> logd("ImageViewKt", "Activity")
//        is FragmentActivity -> logd("ImageViewKt", "FragmentActivity")
//        is ContextWrapper -> logd("ImageViewKt", "ContextWrapper")
//        else -> logd("ImageViewKt", context)
//    }
    return Glide.with(context)
}

// ------------------loadUrl--------------------------------------------------------------------------------------------

@JvmOverloads
fun ImageView.loadUrl(url: String,
                      @DrawableRes placeholder: Int = 0,
                      @DrawableRes error: Int = 0) {
    getGlide(context)
            .load(url)
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(this)
}

// ------------------loadRes--------------------------------------------------------------------------------------------

@JvmOverloads
fun ImageView.loadRes(@DrawableRes res: Int,
                      @DrawableRes placeholder: Int = 0,
                      @DrawableRes error: Int = 0) {
    getGlide(context)
            .load(res)
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(this)
}

// ------------------loadFile--------------------------------------------------------------------------------------------

@JvmOverloads
fun ImageView.loadFile(file: String,
                       @DrawableRes placeholder: Int = 0,
                       @DrawableRes error: Int = 0) {
//    logd("file", file)
    getGlide(context)
            .load("file://$file")
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(this)
}

@JvmOverloads
fun ImageView.loadFile(file: File,
                       @DrawableRes placeholder: Int = 0,
                       @DrawableRes error: Int = 0) {
    getGlide(context)
            .load(file)
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(this)
}

// ------------------loadRes--------------------------------------------------------------------------------------------

@JvmOverloads
fun ImageView.loadGif(@DrawableRes gifResId: Int,
                      @DrawableRes placeholder: Int = 0) {
    getGlide(context)
            .load(gifResId)
            .asGif() //只能加载gif， 加载其他的报错，当然也可以不设置asGif，同样可以加载gif
//                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
            .placeholder(placeholder)
            .dontAnimate()
            .into(this)
}