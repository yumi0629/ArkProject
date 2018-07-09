@file:JvmMultifileClass
@file:JvmName("AnyUtil")

package com.shendx.ark.base.lib.util.ex

/**
 * Created by sdx on 2018/2/9.
 */

val Any?.isNull: Boolean
    get() = this == null

val Any?.isNotNull: Boolean
    get() = this != null

inline infix fun <T> T?.isNull(block: () -> Unit) {
    if (isNull) {
        block()
    }
}

inline infix fun <T> T?.isNotNull(block: (T) -> Unit) {
    if (this != null) {
        block(this)
    }
}