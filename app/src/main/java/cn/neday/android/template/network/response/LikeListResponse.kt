package cn.neday.android.template.network.response

import com.squareup.moshi.Json

data class LikeListResponse(
    val sets: List<Set>,
    val total: Int
)

data class Set(
    @Json(name = "created_time")
    val createdTime: String,
    @Json(name = "user_id")
    val userId: Int
)