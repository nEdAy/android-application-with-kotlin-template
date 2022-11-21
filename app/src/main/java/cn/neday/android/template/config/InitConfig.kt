package cn.neday.android.template.config

import android.app.Application
import cn.neday.android.template.DO_KIT_PRODUCT_ID
import cn.neday.base.config.DoKitConfig
import cn.neday.base.config.LogConfig
import com.didichuxing.doraemonkit.util.ProcessUtils
import com.didichuxing.doraemonkit.util.Utils

object InitConfig {

    fun init(application: Application) {
        Utils.init(application)
        LogConfig.init()
        if (ProcessUtils.isMainProcess()) {
            MMKVConfig.init()
            DoKitConfig.init(DO_KIT_PRODUCT_ID)
        }
    }
}