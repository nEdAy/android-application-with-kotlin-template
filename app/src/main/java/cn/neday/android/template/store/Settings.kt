package cn.neday.android.template.store

import cn.neday.android.template.MMKV_CRYPT_KEY
import com.dylanc.mmkv.MMKVOwner
import com.dylanc.mmkv.mmkvBool
import com.tencent.mmkv.MMKV

/**
 * 配置
 */
object Settings : MMKVOwner {
    private const val mmapID = "settings";
    override val kv: MMKV = MMKV.mmkvWithID(mmapID, MMKV.SINGLE_PROCESS_MODE, MMKV_CRYPT_KEY)

    var isFirstLaunch by mmkvBool(false)
}