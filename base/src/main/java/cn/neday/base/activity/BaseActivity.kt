package cn.neday.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import cn.neday.base.config.MMKVConfig.TOKEN
import cn.neday.base.config.MMKVConfig.kv
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.StringUtils

/**
 * Activity基类
 *
 * @author nEdAy
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null

    protected val binding: VB? get() = _binding

    open val isCheckLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isCheckLogin && StringUtils.isTrimEmpty(kv.decodeString(TOKEN))) {
            //TODO: Jump to Login Page
            ActivityUtils.finishActivity(this)
        }
        _binding = getViewBinding()
        setContentView(binding?.root)
        prepareInitView()
        initView(savedInstanceState)
    }

    protected abstract fun getViewBinding(): VB

    open fun prepareInitView() {
        // do nothing
    }

    /**
     * onCreate
     */
    abstract fun initView(savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
        _binding = null;
    }
}