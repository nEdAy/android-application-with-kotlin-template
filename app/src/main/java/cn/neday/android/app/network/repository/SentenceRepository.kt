package cn.neday.android.app.network.repository

import cn.neday.android.app.network.api.SentenceApi
import cn.neday.android.app.network.entity.SentenceApiResponse
import cn.neday.android.app.network.response.SentenceResponse

/**
 * Sentence Repository
 *
 * @author nEdAy
 */
class SentenceRepository(private val sentenceApi: SentenceApi) {

    suspend fun token(): SentenceApiResponse<String> = sentenceApi.token()

    suspend fun sentence(): SentenceApiResponse<SentenceResponse> = sentenceApi.sentence()
}