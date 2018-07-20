package com.shendx.ark.base.lib.http

import com.google.gson.GsonBuilder
import com.shendx.ark.base.lib.util.json.NullStringToEmptyAdapterFactory
import com.shendx.ark.base.lib.util.json.toJson
import com.shendx.ark.base.lib.util.logd
import com.shendx.ark.base.lib.util.loge
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * PS:
 * Created by sdx on 2018/7/11.
 */
object RetrofitHelper {

    private const val BASE_URL = "http://www.wanandroid.com"

    private const val TIMEOUT: Long = 30L

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //需要检查
                .build()
    }

    private val httpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY //日志输出

        OkHttpClient.Builder()
                // 添加通用的Header
//                .addInterceptor {
//                    val request = it.request()
//                    it.proceed(request)
//                }
                /*
                这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
                出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
                 */
//                .addInterceptor {
//                    val request = it.request()
//                    logd("HTTP", "-->> URL request(${request.method()}):" + request.url())
//                    val originalResponse = it.proceed(request)
//                    logd("HTTP", "<<-- URL request(${request.method()}):" + request.url() + "\ndata : "+originalResponse.body()?.string())
//                    originalResponse.newBuilder().build()
//                }
                .addNetworkInterceptor(httpLoggingInterceptor) //日志输出拦截器
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build()
    }

    /**
     * 去除服务返回的null 字段
     */
    private val gson by lazy {
        GsonBuilder()
                .registerTypeAdapterFactory(NullStringToEmptyAdapterFactory())
                .create()
    }
}