package cn.neday.android.template.network.entity

import com.didichuxing.doraemonkit.util.ToastUtils
import com.google.gson.JsonParseException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException

enum class HttpError(var code: Int, var errorMsg: String) {
    TOKEN_EXPIRE(3001, "token is expired"),
    PARAMS_ERROR(4003, "params is error")
    // ...... more
}

internal fun handlingApiExceptions(code: Int?, errorMsg: String?) = when (code) {
    HttpError.TOKEN_EXPIRE.code -> ToastUtils.showShort(HttpError.TOKEN_EXPIRE.errorMsg)
    HttpError.PARAMS_ERROR.code -> ToastUtils.showShort(HttpError.PARAMS_ERROR.errorMsg)
    else -> errorMsg?.let { ToastUtils.showShort(it) }
}

internal fun handlingExceptions(e: Throwable) = when (e) {
    is HttpException -> ToastUtils.showShort(e.message())
    is CancellationException -> {
    }
    is SocketTimeoutException -> {
    }
    is JsonParseException -> {
    }
    else -> {
    }
}