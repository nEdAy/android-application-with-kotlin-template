package cn.neday.android.app.network.repository

import cn.neday.android.app.network.api.WanAndroidApi
import cn.neday.android.app.network.entity.ApiResponse
import cn.neday.android.app.network.response.Article
import cn.neday.android.app.network.response.ArticleListResponse
import cn.neday.android.app.network.response.BannerResponse

/**
 * WanAndroid Repository
 *
 * @author nEdAy
 */
class WanAndroidRepository(private val wanAndroidApi: WanAndroidApi) : BaseRepository() {

    suspend fun articleList(
        pageIndex: Int? = null, pageSize: Int? = null
    ): ApiResponse<ArticleListResponse> =
        executeHttp { wanAndroidApi.articleList(pageIndex, pageSize) }

    suspend fun articleTop(): ApiResponse<List<Article>> =
        executeHttp { wanAndroidApi.articleTop() }

    suspend fun banner(): ApiResponse<List<BannerResponse>> = executeHttp { wanAndroidApi.banner() }
}