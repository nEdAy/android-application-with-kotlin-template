package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.WanAndroidApi
import cn.neday.android.template.network.entity.ApiResponse

/**
 * WanAndroid Repository
 *
 * @author nEdAy
 */
class WanAndroidRepository(private val wanAndroidApi: WanAndroidApi) : BaseRepository() {

    suspend fun article(
        pageIndex: Int, pageSize: Int
    ): ApiResponse<String> = executeHttp { wanAndroidApi.article(pageIndex, pageSize) }
}