package com.shendx.ark.base.lib.util.json

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by stan on 2018/3/8.
 */
class ParameterizedTypeImpl(private val raw: Class<*>,
                            private val args: Array<Type> = arrayOf())
    : ParameterizedType {
    override fun getActualTypeArguments(): Array<Type> {
        return args
    }

    override fun getRawType(): Type {
        return raw
    }

    override fun getOwnerType(): Type? {
        return null
    }
}
