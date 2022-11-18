package cn.neday.android.template.di

import cn.neday.android.template.network.api.SentenceApi
import cn.neday.android.template.network.repository.SentenceRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single<SentenceApi> {
        get<Retrofit>().create(SentenceApi::class.java)
    }
    single { SentenceRepository(get()) }
}