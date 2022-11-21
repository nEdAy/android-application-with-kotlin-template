package cn.neday.android.template.network.interceptor

import cn.neday.android.template.config.MMKVConfig.TOKEN
import com.tencent.mmkv.MMKV
import okhttp3.Interceptor
import okhttp3.Response

class AuthenticationInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = chain
        .request()
        .newBuilder()
        .header("Authorization", MMKV.defaultMMKV().decodeString(TOKEN) ?: "")
        .build()
        .let { chain.proceed(it) }
}
