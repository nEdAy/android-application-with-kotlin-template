package cn.neday.android.app.config

import android.app.Application
import com.drake.tooltip.ToastConfig

object InitConfig {

    fun init(application: Application) {
        ToastConfig.initialize(application)
        KoinConfig.init(application)
    }
}