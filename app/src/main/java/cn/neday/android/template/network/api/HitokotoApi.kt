package cn.neday.android.template.network.api

import cn.neday.android.template.network.entity.HitokotoApiResponse
import cn.neday.android.template.network.entity.SentenceApiResponse
import cn.neday.android.template.network.response.*
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HitokotoApi {

    @GET("https://v1.hitokoto.cn/")
    suspend fun hitokoto(): HitokotoResponse

    @POST("https://hitokoto.cn/api/restful/v1/auth/login")
    suspend fun token(): SentenceApiResponse<String>

    @GET("https://hitokoto.cn/api/restful/v1/like")
    suspend fun likeInfo(@Query("sentence_uuid") uuid: String): HitokotoApiResponse<LikeInfoResponse>

    @POST("https://hitokoto.cn/api/restful/v1/like")
    suspend fun markLike(@Query("sentence_uuid") uuid: String): HitokotoApiResponse<MarkLikeResponse>

    @POST("https://hitokoto.cn/api/restful/v1/like/cancel")
    suspend fun cancelLike(@Query("sentence_uuid") uuid: String): HitokotoApiResponse<Unit>
}
