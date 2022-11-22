package cn.neday.android.template.network.api

import cn.neday.android.template.network.entity.SentenceApiResponse
import cn.neday.android.template.network.response.SentenceResponse
import retrofit2.http.GET

interface SentenceApi {

    @GET("https://v2.jinrishici.com/token")
    suspend fun token(): SentenceApiResponse<String>

    @GET("https://v2.jinrishici.com/sentence")
    suspend fun sentence(): SentenceApiResponse<SentenceResponse>
}
