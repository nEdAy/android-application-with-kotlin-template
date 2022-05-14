package cn.neday.base.config

import android.app.Application
import com.didichuxing.doraemonkit.DoKit

object DoKitConfig {

    fun init(app: Application, productId: String) {
        DoKit.Builder(app)
            .productId(productId)
            .build()
    }
}