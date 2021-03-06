package cn.neday.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import cn.neday.base.config.MMKVConfig.TOKEN
import cn.neday.base.config.MMKVConfig.kv
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.StringUtils

/**
 * Activity基类
 *
 * @author nEdAy
 */
abstract class BaseActivity(@get:LayoutRes val layoutId: Int?) : AppCompatActivity() {

    open val isCheckLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isCheckLogin && StringUtils.isTrimEmpty(kv.decodeString(TOKEN))) {
            //TODO: Jump to Login Page
            ActivityUtils.finishActivity(this)
        }
        layoutId?.let {
            setContentView(LayoutInflater.from(this).inflate(it, null))
        }
        prepareInitView()
        initView(savedInstanceState)
    }

    open fun prepareInitView() {
        // do nothing
    }

    /**
     * onCreate
     */
    abstract fun initView(savedInstanceState: Bundle?)
}