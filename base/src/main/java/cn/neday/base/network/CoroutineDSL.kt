package cn.neday.base.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drake.tooltip.toast
import com.dylanc.longan.isNetworkAvailable
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * execute in main thread
 * @param start doSomeThing first
 */
fun ViewModel.start(start: (() -> Unit)): ViewModel {
    viewModelScope.launch(Dispatchers.Main) {
        if (isNetworkAvailable) {
            start()
        } else {
            toast("无网络")
        }
    }
    return this
}

/**
 * execute in io thread pool
 * @param loader http request
 */
fun <T> ViewModel.requestAsync(loader: suspend () -> T): Deferred<T> {
    return viewModelScope.async(Dispatchers.IO, start = CoroutineStart.LAZY) {
        loader()
    }
}

/**
 * execute in main thread
 * @param onSuccess callback for onSuccess
 * @param onError callback for onError
 * @param onComplete callback for onComplete
 */
fun <T> Deferred<T>.then(
    viewModelScope: CoroutineScope,
    onSuccess: suspend (T) -> Unit,
    onError: (suspend (String) -> Unit)? = null,
    onComplete: (() -> Unit)? = null
): Job {
    return viewModelScope.launch(context = Dispatchers.Main) {
        try {
            val response = this@then.await()
            onSuccess(response)
        } catch (e: Exception) {
            if (e is CancellationException) {
                return@launch
            }
            e.printStackTrace()
            when (e) {
                is UnknownHostException -> onError?.invoke("Unknown Host Exception!")
                is TimeoutException -> onError?.invoke("Timeout Exception!")
                is SocketTimeoutException -> onError?.invoke("Socket Timeout Exception!")
                else -> onError?.invoke("Other Exception!")
            }
        } finally {
            onComplete?.invoke()
        }
    }
}