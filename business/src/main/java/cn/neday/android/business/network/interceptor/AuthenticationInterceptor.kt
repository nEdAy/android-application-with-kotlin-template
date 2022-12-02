package cn.neday.android.business.network.interceptor

import cn.neday.android.business.store.Data
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain
        .request()
        .newBuilder()
        .header("Authorization", "${Data.token}")
        .build()
        .let { chain.proceed(it) }
}
