package cn.neday.android.base.activity

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.ActivityBinding
import com.dylanc.viewbinding.base.ActivityBindingDelegate
import com.therouter.TheRouter

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
        TheRouter.inject(this);
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