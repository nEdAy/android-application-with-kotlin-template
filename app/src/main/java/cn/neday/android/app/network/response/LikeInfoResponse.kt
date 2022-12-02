package cn.neday.android.app.network.response

import com.squareup.moshi.Json

data class LikeInfoResponse(
    val sets: List<LikeSet>,
    val total: Int
)

data class LikeSet(
    @Json(name = "created_time")
    val createdTime: String,
    @Json(name = "user_id")
    val userId: Int
)