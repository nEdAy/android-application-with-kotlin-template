package cn.neday.android.business.auth.network.api

import cn.neday.android.business.auth.network.request.RegisterRequest
import cn.neday.android.business.auth.network.response.RegisterResponse
import cn.neday.android.business.network.entity.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {

    @POST("/user/login")
    suspend fun login(@Body request: RegisterRequest): ApiResponse<RegisterResponse>

    @POST("/user/register")
    suspend fun register(@Body request: RegisterRequest): ApiResponse<RegisterResponse>

    @GET("/user/logout/json")
    suspend fun logout(): ApiResponse<Unit>
}
