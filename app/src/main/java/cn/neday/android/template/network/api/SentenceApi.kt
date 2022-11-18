package cn.neday.android.template.network.api

import cn.neday.android.template.network.response.BaseSentenceResponse
import cn.neday.android.template.network.response.SentenceResponse
import retrofit2.http.GET

interface SentenceApi {

    @GET("https://v2.jinrishici.com/token")
    suspend fun token(): BaseSentenceResponse<String>

    @GET("https://v2.jinrishici.com/sentence")
    suspend fun sentence(): BaseSentenceResponse<SentenceResponse>
}
