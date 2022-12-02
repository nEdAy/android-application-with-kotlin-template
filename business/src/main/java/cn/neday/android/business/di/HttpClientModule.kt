package cn.neday.android.business.di

import cn.neday.android.business.BASE_URL
import cn.neday.android.business.TIME_OUT_SECONDS
import cn.neday.android.business.network.interceptor.AuthenticationInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val httpClientModule = module {

    single { Retrofit.Builder() }

    single { OkHttpClient.Builder() }

    single<Retrofit> {
        get<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        get<OkHttpClient.Builder>()
            .connectTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(AuthenticationInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
//                level = when (BuildConfig.DEBUG) {
//                    true -> HttpLoggingInterceptor.Level.BODY
//                    false -> HttpLoggingInterceptor.Level.NONE
//                }
            })
//            .addInterceptor(
//                ChuckerInterceptor.Builder(Utils.getApp())
//                    .collector(ChuckerCollector(Utils.getApp()))
//                    .maxContentLength(250000L)
//                    .redactHeaders(emptySet())
//                    .alwaysReadResponseBody(true)
//                    .build()
//            )
            .build()
    }
}