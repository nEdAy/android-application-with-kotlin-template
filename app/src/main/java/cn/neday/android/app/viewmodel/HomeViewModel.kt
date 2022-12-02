package cn.neday.android.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.neday.android.app.network.repository.HitokotoRepository
import cn.neday.android.app.network.response.LikeSet
import cn.neday.base.SingleLiveEvent
import cn.neday.base.network.requestAsync
import cn.neday.base.network.then
import cn.neday.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * HomeViewModel
 *
 * @author nEdAy
 */
class HomeViewModel(private val repository: HitokotoRepository) : BaseViewModel() {

    private val _sentence = MutableStateFlow("")
    val sentence: StateFlow<String> = _sentence

    private val _author = MutableStateFlow("")
    val author: StateFlow<String> = _author

    private val _lickCount = MutableStateFlow(0)
    val lickCount: StateFlow<Int> = _lickCount

    val likeInfo: MutableLiveData<List<LikeSet>> = SingleLiveEvent()

    fun getHitokoto() {
        requestAsync {
            repository.hitokoto()
        }.then(viewModelScope, {
            _sentence.value = it.hitokoto
            _author.value = it.from
            getHitokotoLikeInfo(it.uuid)
        }, {
            errorMessage.value = "请求错误"
        }, {
            onComplete.call()
        })
    }


    private fun getHitokotoLikeInfo(uuid: String) {
        requestAsync {
            repository.likeInfo(uuid)
        }.then(viewModelScope, {
            if (it.status == 200) {
                val likeInfoSets = it.data.first().sets
                likeInfo.value = likeInfoSets
                _lickCount.value = likeInfoSets.size
            } else {
                errorMessage.value = it.message
            }
        }, {
            errorMessage.value = "请求错误"
        }, {
            onComplete.call()
        })
    }
}