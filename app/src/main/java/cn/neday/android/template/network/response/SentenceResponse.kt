package cn.neday.android.template.network.response

data class SentenceResponse(
    val id: String,
    // 是核心，即推荐的诗句
    val content: String,
    // 是与你相关的标签，也是推荐给你的部分理由。
    val matchTags: List<String>,
    //  是推荐原因，暂未支持。
    val recommendedReason: String,
    // 是指我们会对每个 Token 进行预生成推荐数据并缓存。正常情况下我们会10分钟更新一次缓存数据。
    val cacheAt: String,
    // 是我们对这句诗的流行度评价
    val popularity: Int,
    // 源诗信息
    val origin: Origin
)

data class Origin(
    val author: String,
    val content: List<String>,
    val dynasty: String,
    val title: String,
    // 是整诗翻译，部分诗词有，部分没有
    val translate: List<String>
)