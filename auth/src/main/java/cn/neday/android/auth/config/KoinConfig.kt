package cn.neday.android.auth.config

import cn.neday.android.auth.di.repositoryModule
import cn.neday.android.auth.di.viewModelModule
import org.koin.core.context.loadKoinModules

object KoinConfig {

    fun init() {
        loadKoinModules(
            listOf(
                repositoryModule,
                viewModelModule
            )
        )
    }
}