package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.HitokotoApi
import cn.neday.android.template.network.entity.HitokotoApiResponse
import cn.neday.android.template.network.entity.SentenceApiResponse
import cn.neday.android.template.network.response.HitokotoResponse
import cn.neday.android.template.network.response.LikeInfoResponse
import cn.neday.android.template.network.response.MarkLikeResponse

/**
 * Hitokoto Repository
 *
 * @author nEdAy
 */
class HitokotoRepository(private val hitokotoApi: HitokotoApi) : BaseRepository() {

    suspend fun hitokoto(): HitokotoResponse = hitokotoApi.hitokoto()

    suspend fun likeInfo(uuid: String): HitokotoApiResponse<LikeInfoResponse> =
        hitokotoApi.likeInfo(uuid)

    suspend fun markLike(uuid: String): HitokotoApiResponse<MarkLikeResponse> =
        hitokotoApi.markLike(uuid)

    suspend fun cancelLike(uuid: String): HitokotoApiResponse<Unit> =
        hitokotoApi.cancelLike(uuid)

    suspend fun token(): SentenceApiResponse<String> = hitokotoApi.token()
}