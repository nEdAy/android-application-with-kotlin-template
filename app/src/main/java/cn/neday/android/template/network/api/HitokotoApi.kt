package cn.neday.android.template.network.api

import cn.neday.android.template.network.response.*
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HitokotoApi {

    @GET("/")
    suspend fun hitokoto(): HitokotoResponse

    @POST("/auth/login")
    suspend fun token(): BaseSentenceResponse<String>

    @GET("/like")
    suspend fun likeInfo(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<LikeInfoResponse>

    @POST("/like")
    suspend fun markLike(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<MarkLikeResponse>

    @POST("/like/cancel")
    suspend fun cancelLike(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<Unit>
}
