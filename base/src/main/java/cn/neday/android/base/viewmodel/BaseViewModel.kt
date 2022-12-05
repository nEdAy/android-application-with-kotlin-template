package cn.neday.android.base.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import cn.neday.android.base.SingleLiveEvent

/**
 * ViewModel基类
 *
 * @author nEdAy
 */
open class BaseViewModel : ViewModel(), LifecycleObserver {

    val errorMessage = SingleLiveEvent<String>()
    val onComplete = SingleLiveEvent<Unit>()
}