package cn.neday.android.template.config

import android.app.Application
import cn.neday.android.template.di.httpClientModule
import cn.neday.android.template.di.repositoryModule
import cn.neday.android.template.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

object KoinConfig {

    fun init(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(listOf(httpClientModule, repositoryModule, viewModelModule))
        }
    }
}