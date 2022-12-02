package cn.neday.android.app.network.entity

open class ApiResponse<T>(
    val data: T? = null,
    open val errorCode: Int? = null,
    open val errorMsg: String? = null,
    val error: Throwable? = null,
) {
    val isSuccess: Boolean
        get() = errorCode == 0

    override fun toString(): String {
        return "ApiResponse(data=$data, errorCode=$errorCode, errorMsg=$errorMsg, error=$error)"
    }
}

data class ApiSuccessResponse<T>(val response: T) : ApiResponse<T>(data = response)

class ApiEmptyResponse<T> : ApiResponse<T>()

data class ApiFailedResponse<T>(override val errorCode: Int?, override val errorMsg: String?) :
    ApiResponse<T>(errorCode = errorCode, errorMsg = errorMsg)

data class ApiErrorResponse<T>(val throwable: Throwable) : ApiResponse<T>(error = throwable)
