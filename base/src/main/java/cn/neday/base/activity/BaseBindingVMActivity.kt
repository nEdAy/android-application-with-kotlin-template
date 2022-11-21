package cn.neday.base.activity

import androidx.viewbinding.ViewBinding
import cn.neday.base.viewmodel.BaseViewModel
import com.didichuxing.doraemonkit.util.LogUtils

/**
 * Activity 基类 + Binding + ViewModel
 *
 * @author nEdAy
 */
abstract class BaseBindingVMActivity<VB : ViewBinding, ViewModel : BaseViewModel> :
    BaseBindingActivity<VB>() {

    protected abstract val mViewModel: ViewModel

    override fun prepareInitView() {
        super.prepareInitView()
        lifecycle.addObserver(mViewModel)
        mViewModel.errMsg.observe(this) {
            LogUtils.e(it)
        }
    }
}