package com.shendx.ark.base.lib.http.api

import com.shendx.ark.base.lib.http.RetrofitHelper
import com.shendx.ark.biz.wanandroid.bean.response.ArticleListBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

val RetrofitHelper.wanApi by lazy { RetrofitHelper.retrofit.create(WanApi::class.java) }

interface WanApi {
    @GET("/article/list/{id}/json")
    fun articleList(@Path("id") id: Int): Observable<ResponseWan<ArticleListBean>>
}