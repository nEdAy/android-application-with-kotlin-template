package cn.neday.base.network.interceptor

import cn.neday.base.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

class HttpLoggingInterceptor private constructor() {
    companion object {
        val instance: HttpLoggingInterceptor by lazy {
            HttpLoggingInterceptor().apply {
                level = when (BuildConfig.DEBUG) {
                    true -> HttpLoggingInterceptor.Level.BODY
                    false -> HttpLoggingInterceptor.Level.NONE
                }
            }
        }
    }
}