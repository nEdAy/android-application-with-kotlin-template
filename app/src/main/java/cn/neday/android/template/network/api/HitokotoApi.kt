package cn.neday.android.template.network.api

import cn.neday.android.template.network.response.*
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface HitokotoApi {

    @GET("")
    suspend fun hitokoto(): HitokotoResponse

    @POST("auth/login")
    suspend fun token(): BaseSentenceResponse<String>

    @GET("like")
    suspend fun likeList(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<LikeListResponse>

    @POST("like")
    suspend fun like(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<LikeResponse>

    @POST("like/cancel")
    suspend fun likeCancel(@Query("sentence_uuid") uuid: String): BaseHitokotoResponse<Unit>
}
