package cn.neday.android.template.network.response

import com.squareup.moshi.Json

data class LikeResponse(
    val ip: String,
    @Json(name = "userId")
    val user_id: Int
)
