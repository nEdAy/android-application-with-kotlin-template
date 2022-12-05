package cn.neday.android.business.auth.di

import cn.neday.android.business.auth.network.api.AuthApi
import cn.neday.android.business.auth.network.repository.AuthRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single<AuthApi> {
        get<Retrofit>().create(AuthApi::class.java)
    }
    single { AuthRepository(get()) }
}