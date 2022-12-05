package cn.neday.android.business.auth.network.request

data class RegisterRequest(
    val username: String,
    val password: String,
    val repassword: String
)