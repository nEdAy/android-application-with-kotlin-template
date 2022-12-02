package cn.neday.android.app.network.response

import com.squareup.moshi.Json

data class HitokotoResponse(
    // 一言标识
    val id: Int,
    // 一言正文。编码方式 unicode。使用 utf-8。
    val hitokoto: String,
    // 类型。请参考第三节参数的表格
    val type: String,
    // 一言的出处
    val from: String,
    // 一言的作者
    @Json(name = "from_who")
    val fromWho: String,
    // 添加者
    val creator: String,
    // 添加者标识
    @Json(name = "creator_uid")
    val creatorUid: Int,
    // 审核员标识
    val reviewer: Int,
    // 一言唯一标识；可以链接到 https://hitokoto.cn?uuid=[uuid] (opens new window)查看这个一言的完整信息
    val uuid: String,
    // 提交方式
    @Json(name = "commit_from")
    val commitFrom: String,
    // 添加时间
    @Json(name = "created_at")
    val createdAt: String,
    // 句子长度
    val length: Int
)
