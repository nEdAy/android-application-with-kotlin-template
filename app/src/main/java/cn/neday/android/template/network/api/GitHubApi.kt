package cn.neday.android.template.network.api

import cn.neday.android.template.network.response.SearchUsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/users")
    suspend fun searchUsers(@Query("q") keyword: String): SearchUsersResponse
}