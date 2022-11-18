package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.SentenceApi
import cn.neday.android.template.network.response.BaseSentenceResponse
import cn.neday.android.template.network.response.SentenceResponse

/**
 * Sentence Repository
 *
 * @author nEdAy
 */
class SentenceRepository(private val sentenceApi: SentenceApi) {

    suspend fun token(): BaseSentenceResponse<String> = sentenceApi.token()

    suspend fun sentence(): BaseSentenceResponse<SentenceResponse> = sentenceApi.sentence()
}