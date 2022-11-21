package cn.neday.base.config

import com.didichuxing.doraemonkit.util.AppUtils
import com.didichuxing.doraemonkit.util.LogUtils

object LogConfig {

    fun init() {
        LogUtils.getConfig().isLogSwitch = AppUtils.isAppDebug()
    }
}