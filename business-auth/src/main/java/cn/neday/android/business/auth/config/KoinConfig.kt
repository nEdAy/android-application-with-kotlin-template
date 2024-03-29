package cn.neday.android.business.auth.config

import cn.neday.android.business.auth.di.repositoryModule
import cn.neday.android.business.auth.di.viewModelModule
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