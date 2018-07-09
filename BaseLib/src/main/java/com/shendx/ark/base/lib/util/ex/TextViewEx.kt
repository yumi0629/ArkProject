@file:JvmMultifileClass
@file:JvmName("TextViewUtil")

package com.shendx.ark.base.lib.util.ex

import android.widget.TextView

val TextView.textStr: String
    get() = this.text.trim().toString()