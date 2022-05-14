package cn.neday.android.template.network.repository

import cn.neday.android.template.network.api.GitHubApi
import cn.neday.android.template.network.response.SearchUsersResponse

/**
 * Hitokoto Repository
 *
 * @author nEdAy
 */
class GitHubRepository(private val gitHubApi: GitHubApi) {
    suspend fun searchUsers(keyword: String): SearchUsersResponse = gitHubApi.searchUsers(keyword)
}