package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.HitokotoApi
import cn.neday.android.template.network.response.BaseSentenceResponse
import cn.neday.android.template.network.response.HitokotoResponse

/**
 * Hitokoto Repository
 *
 * @author nEdAy
 */
class HitokotoRepository(private val hitokotoApi: HitokotoApi) {

    suspend fun hitokoto(): HitokotoResponse = hitokotoApi.hitokoto()

    suspend fun token(): BaseSentenceResponse<String> = hitokotoApi.token()
}