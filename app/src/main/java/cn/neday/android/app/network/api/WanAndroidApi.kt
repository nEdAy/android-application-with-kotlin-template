package cn.neday.android.app.network.api

import cn.neday.android.app.network.entity.ApiResponse
import cn.neday.android.app.network.response.Article
import cn.neday.android.app.network.response.ArticleListResponse
import cn.neday.android.app.network.response.BannerResponse
import cn.neday.android.business.INITIAL_PAGE_INDEX
import cn.neday.android.business.PAGE_SIZE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WanAndroidApi {

    @GET("/article/list/{pageIndex}/json")
    suspend fun articleList(
        @androidx.annotation.IntRange(from = 0)
        @Path("pageIndex") pageIndex: Int? = INITIAL_PAGE_INDEX,
        @androidx.annotation.IntRange(from = 1, to = 40)
        @Query("page_size") pageSize: Int? = PAGE_SIZE
    ): ApiResponse<ArticleListResponse>

    @GET("/article/top/json")
    suspend fun articleTop(): ApiResponse<List<Article>>

    @GET("/banner/json")
    suspend fun banner(): ApiResponse<List<BannerResponse>>

    @POST("/user/login")
    suspend fun login(): ApiResponse<List<BannerResponse>>

    @POST("/user/register")
    suspend fun register(): ApiResponse<List<BannerResponse>>

    @GET("/user/logout/json")
    suspend fun logout(): ApiResponse<List<BannerResponse>>
}
