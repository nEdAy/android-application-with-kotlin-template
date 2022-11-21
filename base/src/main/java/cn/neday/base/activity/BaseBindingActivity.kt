package cn.neday.base.activity

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.neday.base.config.MMKVConfig.TOKEN
import cn.neday.base.config.MMKVConfig.kv
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.StringUtils
import com.dylanc.viewbinding.base.ActivityBinding
import com.dylanc.viewbinding.base.ActivityBindingDelegate

/**
 * Activity 基类 + Binding
 *
 * @author nEdAy
 */
abstract class BaseBindingActivity<VB : ViewBinding> : AppCompatActivity(),
    ActivityBinding<VB> by ActivityBindingDelegate() {

    open val isCheckLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isCheckLogin && StringUtils.isTrimEmpty(kv.decodeString(TOKEN))) {
            //TODO: Jump to Login Page
            ActivityUtils.finishActivity(this)
        }
        setContentViewWithBinding()
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

    @Suppress("DEPRECATION")
    protected fun setFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}