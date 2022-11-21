package cn.neday.android.template.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.neday.android.template.network.repository.HitokotoRepository
import cn.neday.android.template.network.response.HitokotoResponse
import cn.neday.base.SingleLiveEvent
import cn.neday.base.network.requestAsync
import cn.neday.base.network.then
import cn.neday.base.viewmodel.BaseViewModel

/**
 * MainViewModel
 *
 * @author nEdAy
 */
class MainViewModel(private val repository: HitokotoRepository) : BaseViewModel() {

    val hitokoto: MutableLiveData<HitokotoResponse> = SingleLiveEvent()

    fun getHitokoto() {
        requestAsync {
            repository.hitokoto()
        }.then(viewModelScope, {
            hitokoto.value = it
        }, {
            errMsg.value = "请求错误"
        }, {
            onComplete.call()
        })
    }
}