package cn.neday.android.auth.di

import cn.neday.android.auth.network.api.AuthApi
import cn.neday.android.auth.network.repository.AuthRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single<AuthApi> {
        get<Retrofit>().create(AuthApi::class.java)
    }
    single { AuthRepository(get()) }
}