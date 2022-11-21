package cn.neday.android.template.di

import cn.neday.android.template.BASE_URL
import cn.neday.android.template.TIME_OUT_SECONDS
import cn.neday.android.template.network.interceptor.AuthenticationInterceptor
import cn.neday.base.network.interceptor.ChuckerInterceptor
import cn.neday.base.network.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
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
            .addInterceptor(HttpLoggingInterceptor.instance)
            .addInterceptor(ChuckerInterceptor.instance)
            .build()
    }
}