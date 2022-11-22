package cn.neday.android.template.network.api

import cn.neday.android.template.INITIAL_PAGE_INDEX
import cn.neday.android.template.PAGE_SIZE
import cn.neday.android.template.network.entity.ApiResponse
import cn.neday.android.template.network.entity.SentenceApiResponse
import cn.neday.android.template.network.response.SentenceResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WanAndroidApi {

    @GET("/article/list/{pageIndex}/json")
    suspend fun article(
        @androidx.annotation.IntRange(from = 0)
        @Path("pageIndex") pageIndex: Int = INITIAL_PAGE_INDEX,
        @androidx.annotation.IntRange(from = 1, to = 40)
        @Query("page_size") pageSize: Int = PAGE_SIZE
    ): ApiResponse<String>

    @GET("https://v2.jinrishici.com/sentence")
    suspend fun sentence(): SentenceApiResponse<SentenceResponse>
}
