package com.shendx.ark.base.lib.http

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * PS:
 * Created by sdx on 2018/7/11.
 */
object RxSchedulers {

    fun <T> compose(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream
                    .subscribeOn(Schedulers.io()) //被订阅者发生的线程
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}