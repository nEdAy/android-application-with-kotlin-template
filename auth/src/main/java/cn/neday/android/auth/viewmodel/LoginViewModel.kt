package cn.neday.android.auth.viewmodel

import cn.neday.android.auth.network.repository.AuthRepository
import cn.neday.base.viewmodel.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * LoginViewModel
 *
 * @author nEdAy
 */
class LoginViewModel(private val repository: AuthRepository) : BaseViewModel() {

    private val _sentence = MutableStateFlow("")
    val sentence: StateFlow<String> = _sentence

    private val _author = MutableStateFlow("")
    val author: StateFlow<String> = _author

    private val _lickCount = MutableStateFlow(0)
    val lickCount: StateFlow<Int> = _lickCount

    fun login() {

    }
}