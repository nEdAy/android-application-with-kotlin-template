package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.HitokotoApi
import cn.neday.android.template.network.response.BaseSentenceResponse
import cn.neday.android.template.network.response.SentenceResponse

/**
 * Hitokoto Repository
 *
 * @author nEdAy
 */
class HitokotoRepository(private val hitokotoApi: HitokotoApi) {

    suspend fun token(): BaseSentenceResponse<String> = hitokotoApi.token()

    suspend fun sentence(): BaseSentenceResponse<SentenceResponse> = hitokotoApi.sentence()
}