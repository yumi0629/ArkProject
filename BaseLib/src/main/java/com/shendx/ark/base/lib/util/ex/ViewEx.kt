@file:JvmMultifileClass
@file:JvmName("ViewUtil")

package com.shendx.ark.base.lib.util.ex

import android.view.View

/**
 * PS:
 * Created by sdx on 2018/4/24.
 */
val View.isVisibility: Boolean
    get() = this.visibility == View.VISIBLE

