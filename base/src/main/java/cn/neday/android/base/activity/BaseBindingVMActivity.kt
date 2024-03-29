package cn.neday.android.base.activity

import androidx.viewbinding.ViewBinding
import cn.neday.android.base.viewmodel.BaseViewModel
import com.dylanc.longan.logError

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
        mViewModel.errorMessage.observe(this) {
            logError(it)
        }
    }
}