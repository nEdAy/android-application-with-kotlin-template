package cn.neday.android.template.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.neday.android.template.network.repository.SentenceRepository
import cn.neday.android.template.network.response.SentenceResponse
import cn.neday.base.network.requestAsync
import cn.neday.base.network.then
import cn.neday.base.viewmodel.BaseViewModel

/**
 * ListViewModel
 *
 * @author nEdAy
 */
class ListViewModel(private val repository: SentenceRepository) : BaseViewModel() {

    val sentence: MutableLiveData<SentenceResponse?> = MutableLiveData()

    fun getToken() {
        requestAsync {
            repository.token()
        }.then(viewModelScope, {
            val token = it.data
        }, {
            errorMessage.value = it
        }, {
            onComplete.call()
        })
    }

    fun getSentence() {
        requestAsync {
            repository.sentence()
        }.then(viewModelScope, {
            sentence.value = it.data
        }, {
            errorMessage.value = it
        }, {
            onComplete.call()
        })
    }
}