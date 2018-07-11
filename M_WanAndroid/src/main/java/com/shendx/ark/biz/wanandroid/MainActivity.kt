package com.shendx.ark.biz.wanandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shendx.ark.base.lib.http.RetrofitHelper
import com.shendx.ark.base.lib.http.RxSchedulers
import com.shendx.ark.base.lib.util.loge
import com.shendx.ark.biz.wanandroid.http.ResponseWan
import com.shendx.ark.biz.wanandroid.http.WanApi
import com.shendx.ark.biz.wanandroid.model.ArticleListBean
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.m_wan_activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.m_wan_activity_main)
        text.setOnClickListener {
            RetrofitHelper.WanApi
                    .articleList(0)
                    .compose(RxSchedulers.compose())
                    .subscribe(object : Observer<ResponseWan<ArticleListBean>> {
                        override fun onComplete() {
                            loge("onComplete")
                        }

                        override fun onSubscribe(d: Disposable) {
                            loge("onSubscribe")
                        }

                        override fun onNext(t: ResponseWan<ArticleListBean>) {
                            loge("onNext")
                        }

                        override fun onError(e: Throwable) {
                            loge(e)
                        }
                    })
        }
    }
}
