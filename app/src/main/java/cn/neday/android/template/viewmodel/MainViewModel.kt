package cn.neday.android.template.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cn.neday.android.template.network.repository.GitHubRepository
import cn.neday.android.template.network.response.Item
import cn.neday.base.network.requestAsync
import cn.neday.base.network.then
import cn.neday.base.viewmodel.BaseViewModel

/**
 * MainViewModel
 *
 * @author nEdAy
 */
class MainViewModel(private val repository: GitHubRepository) : BaseViewModel() {
    val users: MutableLiveData<MutableList<Item>> = MutableLiveData()

    fun searchUsersByKeyword(keyword: String = "") {
        requestAsync {
            repository.searchUsers(keyword)
        }.then(viewModelScope, {
            users.value = it.items
        }, {
            errMsg.value = it
        }, {
            onComplete.call()
        })
    }
}