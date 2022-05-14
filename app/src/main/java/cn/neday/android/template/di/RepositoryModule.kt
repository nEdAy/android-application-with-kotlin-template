package cn.neday.android.template.di

import cn.neday.android.template.network.api.GitHubApi
import cn.neday.android.template.network.repository.GitHubRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single<GitHubApi> {
        get<Retrofit>().create(GitHubApi::class.java)
    }
    single { GitHubRepository(get()) }
}