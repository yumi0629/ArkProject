package com.shendx.ark.biz.wanandroid.http

import com.shendx.ark.base.lib.http.RetrofitHelper
import com.shendx.ark.biz.wanandroid.model.ArticleListBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * PS:
 * Created by sdx on 2018/7/10.
 */
interface WanApi {
    @GET("/article/list/{id}/json")
    fun articleList(@Path("id") id: Int): Observable<ResponseWan<ArticleListBean>>
}

val RetrofitHelper.WanApi: WanApi
    get() {
        return RetrofitHelper.retrofit.create(WanApi::class.java)
    }