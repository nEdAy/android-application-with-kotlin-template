package cn.neday.base.config

import com.didichuxing.doraemonkit.DoKit
import com.didichuxing.doraemonkit.util.Utils

object DoKitConfig {

    fun init(productId: String) {
        DoKit.Builder(Utils.getApp())
            .productId(productId)
            .build()
    }
}