//package cn.neday.android.template.network.interceptor
//
//import okhttp3.Interceptor
//import okhttp3.Response
//import org.json.JSONObject
//
///**
// * 自动刷新token令牌
// */
//class RefreshTokenInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val response = chain.proceed(request) // 如果token失效
//
//        return synchronized(RefreshTokenInterceptor::class.java) {
//            if (response.code == 401 && UserConfig.isLogin && !request.url.pathSegments.contains("token")) {
//                val json = Net.get("token").execute<String>() // 同步刷新token
//                val jsonObject = JSONObject(json)
//                if (jsonObject.getBoolean("isExpired")) {
//                    toast("登录状态失效")
//                    // token刷新失败跳转到登录界面重新登录
//                } else {
//                    UserConfig.token = jsonObject.optString("token")
//                }
//                chain.proceed(request)
//            } else {
//                response
//            }
//        }
//    }
//}