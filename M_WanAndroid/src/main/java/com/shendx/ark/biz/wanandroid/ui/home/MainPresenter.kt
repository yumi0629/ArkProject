package com.shendx.ark.biz.wanandroid.ui.home

import com.shendx.ark.base.lib.http.RetrofitHelper
import com.shendx.ark.base.lib.http.RxSchedulers
import com.shendx.ark.base.lib.http.api.ResponseWan
import com.shendx.ark.base.lib.http.api.wanApi
import com.shendx.ark.base.lib.util.loge
import com.shendx.ark.biz.wanandroid.bean.response.ArticleListBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainPresenter(var view: MainContract.MainView)
    : MainContract.IMainPresenter {
    fun articleList(id: Int) {
        RetrofitHelper.wanApi
                .articleList(id)
                .compose(RxSchedulers.compose())
                .subscribe(object : Observer<ResponseWan<ArticleListBean>> {
                    override fun onSubscribe(d: Disposable) {
                        loge("onSubscribe")
                    }

                    override fun onNext(t: ResponseWan<ArticleListBean>) {
                        t.data?.let {
                            view.showData(it.datas)
                        }
                    }

                    override fun onError(e: Throwable) {
                        loge("onError")
                    }

                    override fun onComplete() {
                        loge("onComplete")
                    }
                })
    }

}