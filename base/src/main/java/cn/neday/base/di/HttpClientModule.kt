package cn.neday.base.di

import cn.neday.base.BuildConfig
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.didichuxing.doraemonkit.util.Utils
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val namedChuckerInterceptor = "ChuckerInterceptor";
const val namedHttpLoggingInterceptor = "HttpLoggingInterceptor";

val httpInterceptorModule = module {

    single(named(namedChuckerInterceptor)) {
        ChuckerInterceptor.Builder(Utils.getApp())
            .collector(ChuckerCollector(Utils.getApp()))
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()
    }

    single(named(namedHttpLoggingInterceptor)) {
        HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG) {
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}