@file:JvmMultifileClass
@file:JvmName("CollectionUtil")
@file:Suppress("unused")

package com.shendx.ark.base.lib.util.ex

/**
 * 英文逗号 划分的 string
 */
fun <T> Iterable<T>.toCommaString(): String {
    val stringBuffer = StringBuffer()
    this.forEach {
        stringBuffer.append(",")
        stringBuffer.append(it.toString())
    }
    if (stringBuffer.isNotEmpty()) {
        stringBuffer.deleteCharAt(0)
    }
    return stringBuffer.toString()
}

/**
 * 英文逗号 划分的 string
 */
fun <T> Iterable<T>.toCommaString(block: (T) -> String): String {
    val stringBuffer = StringBuffer()
    this.forEach {
        stringBuffer.append(",")
        stringBuffer.append(block(it))
    }
    if (stringBuffer.isNotEmpty()) {
        stringBuffer.deleteCharAt(0)
    }
    return stringBuffer.toString()
}