package com.shendx.ark.base.lib.http

import com.shendx.ark.base.lib.http.api.ResponseWan
import com.shendx.ark.base.lib.util.loge
import io.reactivex.Observable
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
                    .compose(check())
                    .subscribeOn(Schedulers.io()) //被订阅者发生的线程
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    private fun <T> check(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.flatMap {
                return@flatMap when (it) {
                    is ResponseWan<*> -> {
                        return@flatMap if (it.errorCode < 0) {
                            Observable.error(Throwable(it.errorMsg))
                        } else {
                            Observable.just(it)
                        }
                    }
                    else -> Observable.just(it)
                }

            }
        }
    }
}