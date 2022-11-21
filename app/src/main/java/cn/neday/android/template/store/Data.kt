package cn.neday.android.template.store

import cn.neday.android.template.MMKV_CRYPT_KEY
import com.dylanc.longan.internalFileDirPath
import com.dylanc.mmkv.MMKVOwner
import com.dylanc.mmkv.mmkvString
import com.tencent.mmkv.MMKV

/**
 * 数据
 */
object Data : MMKVOwner {
    private const val mmapID = "data"
    private const val manualMMKVDir = "/mmkv/$mmapID"
    override val kv: MMKV = MMKV.mmkvWithID(mmapID, MMKV.SINGLE_PROCESS_MODE, MMKV_CRYPT_KEY)

    var token by mmkvString()

    fun manualBackup(): Boolean {
        return MMKV.backupOneToDirectory(
            mmapID,
            "$internalFileDirPath$manualMMKVDir",
            null
        )
    }

    fun manualRestore(): Boolean {
        return MMKV.restoreOneMMKVFromDirectory(
            mmapID,
            "$internalFileDirPath$manualMMKVDir",
            null
        )
    }
}