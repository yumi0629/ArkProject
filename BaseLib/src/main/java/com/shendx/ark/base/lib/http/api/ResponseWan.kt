package com.shendx.ark.base.lib.http.api

/**
 * PS:
 * Created by sdx on 2018/7/11.
 */
data class ResponseWan<T>(
        var data: T? = null,
        var errorCode: Int = -1,
        var errorMsg: String = ""
)