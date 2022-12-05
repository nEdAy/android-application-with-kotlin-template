package cn.neday.android.business.auth.network.repository

import cn.neday.android.business.auth.network.api.AuthApi
import cn.neday.android.business.auth.network.request.RegisterRequest
import cn.neday.android.business.auth.network.response.RegisterResponse
import cn.neday.android.business.network.entity.ApiResponse
import cn.neday.android.business.network.repository.BaseRepository

/**
 * WanAndroid Auth Repository
 *
 * @author nEdAy
 */
class AuthRepository(private val authApi: AuthApi) : BaseRepository() {

    suspend fun login(request: RegisterRequest): ApiResponse<RegisterResponse> =
        executeHttp { authApi.login(request) }

    suspend fun register(request: RegisterRequest): ApiResponse<RegisterResponse> =
        executeHttp { authApi.register(request) }

    suspend fun logout(): ApiResponse<Unit> = executeHttp { authApi.logout() }
}