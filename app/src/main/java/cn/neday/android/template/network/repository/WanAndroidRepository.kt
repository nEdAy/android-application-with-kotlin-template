package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.WanAndroidApi
import cn.neday.android.template.network.entity.ApiResponse
import cn.neday.android.template.network.response.ArticleResponse
import cn.neday.android.template.network.response.BannerResponse

/**
 * WanAndroid Repository
 *
 * @author nEdAy
 */
class WanAndroidRepository(private val wanAndroidApi: WanAndroidApi) : BaseRepository() {

    suspend fun article(
        pageIndex: Int, pageSize: Int
    ): ApiResponse<ArticleResponse> = executeHttp { wanAndroidApi.article(pageIndex, pageSize) }

    suspend fun banner(): ApiResponse<List<BannerResponse>> = executeHttp { wanAndroidApi.banner() }
}