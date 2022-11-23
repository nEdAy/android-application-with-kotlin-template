package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.WanAndroidApi
import cn.neday.android.template.network.entity.ApiResponse
import cn.neday.android.template.network.response.Article
import cn.neday.android.template.network.response.ArticleListResponse
import cn.neday.android.template.network.response.BannerResponse

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