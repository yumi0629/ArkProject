@file:JvmMultifileClass
@file:JvmName("EditTextUtil")

package com.shendx.ark.base.lib.util.ex

import android.widget.EditText

/**
 * Created by stan on 2018/4/17.
 */
fun EditText.setTextFilterZero(inputTx: String) {
    try {
        if (inputTx.toInt() == 0) {
            this.setText("")
            return
        }
    } catch (e: Exception) {
    }
    this.setText(inputTx)
}

fun EditText.getTextFilterEmpty(): String {
    val inputTx = this.text.trim().toString()
    if (inputTx.isEmpty()) {
        return "0"
    }
    return inputTx
}
