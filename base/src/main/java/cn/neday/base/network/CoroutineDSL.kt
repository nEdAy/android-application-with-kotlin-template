package cn.neday.base.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.NetworkUtils
import kotlinx.coroutines.*
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * execute in main thread
 * @param start doSomeThing first
 */
fun ViewModel.start(start: (() -> Unit)): ViewModel {
    viewModelScope.launch(Dispatchers.Main) {
        if (NetworkUtils.isConnected()) {
            start()
        } else {
            // TODO: show network tips
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
    onError: suspend (String) -> Unit,
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
                is UnknownHostException -> onError("Unknown Host Exception!")
                is TimeoutException -> onError("Timeout Exception!")
                is SocketTimeoutException -> onError("Socket Timeout Exception!")
                else -> onError("Other Exception!")
            }
        } finally {
            onComplete?.invoke()
        }
    }
}