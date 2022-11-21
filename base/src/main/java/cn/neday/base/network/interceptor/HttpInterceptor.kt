package cn.neday.base.network.interceptor

import cn.neday.base.BuildConfig
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.didichuxing.doraemonkit.util.Utils
import okhttp3.logging.HttpLoggingInterceptor

object HttpInterceptorModule {

    fun chuckerInterceptor(): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(Utils.getApp())
            .collector(ChuckerCollector(Utils.getApp()))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()
    }

    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}