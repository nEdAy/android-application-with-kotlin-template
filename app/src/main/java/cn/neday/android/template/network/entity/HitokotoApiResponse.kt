package cn.neday.android.template.network.entity

data class HitokotoApiResponse<T>(
    // 200
    // 状态码。正整数定义符合 HTTP 状态码约束，自定义错误为负值。请注意，由于偷懒，目前错误码存在重复定义，请以具体接口为准。
    val status: Int,
    // "ok."
    // 信息，当状态码不为 200 时，补充说明错误的字段。
    val message: String,
    // []
    // 当状态码为 200 时，且接口不为无返回接口，该字段会返回一个长度大于等于 1 的数组；400 状态码下可能包含校验器的报错信息；其余时候为空数组
    val data: List<T>,
    // 1581759895072
    // 接口时间戳，可用于时间比对
    val ts: Double
)
