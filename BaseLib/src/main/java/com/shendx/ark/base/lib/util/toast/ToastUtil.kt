@file:JvmMultifileClass
@file:JvmName("ToastUtil")

package com.shendx.ark.base.lib.util.toast

import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.Gravity
import android.widget.Toast

import com.shendx.ark.base.lib.BaseApplication
import com.shendx.ark.base.lib.util.getStringRes

/**
 * Toast工具类
 */
object ToastUtil {
    private var toast: Toast? = null
    private var oldMsg: String? = null
    private var oneTime: Long = 0
    private var twoTime: Long = 0

    fun showToast(@StringRes resId: Int) {
        showToast(getStringRes(resId))
    }

    fun showToast(s: String) {
        if (TextUtils.isEmpty(s)) {
            return
        }
        if (toast == null) {
            toast = Toast.makeText(BaseApplication.context, s, Toast.LENGTH_SHORT)
            toast?.setGravity(Gravity.CENTER, 0, 0)
            toast?.show()
            oneTime = System.currentTimeMillis()
        } else {
            twoTime = System.currentTimeMillis()
            if (s == oldMsg) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast?.show()
                }
            } else {
                oldMsg = s
                toast?.setText(s)
                toast?.show()
            }
        }
        oneTime = twoTime
    }
}

fun toast(text: String?) {
    ToastUtil.showToast(text ?: "")
}

fun toast(@StringRes res: Int) {
    ToastUtil.showToast(res)
}
