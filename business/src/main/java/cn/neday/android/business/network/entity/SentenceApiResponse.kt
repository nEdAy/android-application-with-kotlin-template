package cn.neday.android.business.network.entity

data class SentenceApiResponse<T>(
    // "success" "error",
    val status: String,
    val data: T,

    // "6453911a-9ad7-457e-9b9d-c21011b85a0c"
    // 是当前用户的 token ，原则上，同一个用户，一段时间内 Token 应该不变。
    val token: String?,
    // "162.248.93.154"
    // 是当前用户的 ip ，如果 IP 有异常，您需要查明您是否在服务端调用
    val ipAddress: String?,

    // 1001 ：内部服务器错误，HTTP状态码 500
    // 1002 ：API路径不对，HTTP状态码 404
    // 2002 ：Token不是服务器签发，HTTP状态码 400
    // 2003 ：IP超过每日新用户限制，HTTP状态码 400，这很有可能是您没有正确保存 Cookies 或者 Token
    val errCode: Int?,
    // "No matching handler"
    val errMessage: String?
)