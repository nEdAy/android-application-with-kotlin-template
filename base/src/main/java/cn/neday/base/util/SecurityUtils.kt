package cn.neday.base.util

import cn.neday.base.BuildConfig
import cn.neday.base.R
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.DeviceUtils
import com.blankj.utilcode.util.StringUtils.getString
import com.blankj.utilcode.util.ToastUtils

object SecurityUtils {

    fun checkIsAppRoot() {
        if (DeviceUtils.isDeviceRooted() && AppUtils.isAppRoot()) {
            ToastUtils.showLong(getString(R.string.root_tips))
        }
    }

    fun checkIsAppDebug() {
        if (!BuildConfig.DEBUG && AppUtils.isAppDebug()) {
            ToastUtils.showLong(getString(R.string.debug_tips))
            AppUtils.exitApp()
        }
    }
}
