package cn.neday.base.network.interceptor

import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.didichuxing.doraemonkit.util.Utils

class ChuckerInterceptor private constructor() {
    companion object {
        val instance: ChuckerInterceptor by lazy {
            ChuckerInterceptor.Builder(Utils.getApp())
                .collector(ChuckerCollector(Utils.getApp()))
                .maxContentLength(250000L)
                .redactHeaders(emptySet())
                .alwaysReadResponseBody(true)
                .build()
        }
    }
}