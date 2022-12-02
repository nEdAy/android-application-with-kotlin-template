package cn.neday.android.app.network.response

import com.squareup.moshi.Json

data class MarkLikeResponse(
    val ip: String,
    @Json(name = "userId")
    val user_id: Int
)
