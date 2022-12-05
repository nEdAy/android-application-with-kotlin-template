package cn.neday.android.business.auth.network.request

data class LoginRequest(
    val username: String,
    val password: String,
)