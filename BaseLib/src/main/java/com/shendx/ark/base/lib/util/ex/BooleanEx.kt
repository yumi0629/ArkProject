@file:JvmMultifileClass
@file:JvmName("BooleanUtil")

package com.shendx.ark.base.lib.util.ex

/**
 *
 * Created by sdx on 2018/4/19.
 */

inline infix fun Boolean?.yes(block: () -> Unit): Boolean? {
    if (this == true) {
        block()
    }
    return this
}

inline infix fun Boolean?.no(block: () -> Unit): Boolean? {
    if (this != true) {
        block()
    }
    return this
}

inline fun Boolean.invoke(block: () -> Unit) = yes(block)