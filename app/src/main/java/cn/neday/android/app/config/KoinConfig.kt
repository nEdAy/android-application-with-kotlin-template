package cn.neday.android.app.config

import android.app.Application
import cn.neday.android.app.di.repositoryModule
import cn.neday.android.app.di.viewModelModule
import cn.neday.android.business.di.httpClientModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object KoinConfig {

    fun init(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(
                listOf(
                    httpClientModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}