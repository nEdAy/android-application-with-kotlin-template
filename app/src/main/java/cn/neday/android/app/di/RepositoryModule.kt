package cn.neday.android.app.di

import cn.neday.android.app.network.api.HitokotoApi
import cn.neday.android.app.network.api.SentenceApi
import cn.neday.android.app.network.repository.HitokotoRepository
import cn.neday.android.app.network.repository.SentenceRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryModule = module {

    single<HitokotoApi> {
        get<Retrofit>().create(HitokotoApi::class.java)
    }
    single { HitokotoRepository(get()) }

    single<SentenceApi> {
        get<Retrofit>().create(SentenceApi::class.java)
    }
    single { SentenceRepository(get()) }
}