package cn.neday.android.base.fragment

import androidx.viewbinding.ViewBinding
import cn.neday.android.base.viewmodel.BaseViewModel
import com.dylanc.longan.logError

/**
 * Fragment 基类 + Binding + ViewModel
 *
 * @author nEdAy
 */
abstract class BaseBindingVMFragment<VB : ViewBinding, VM : BaseViewModel> :
    BaseBindingFragment<VB>() {

    protected abstract val viewModel: VM

    override fun prepareInitView() {
        super.prepareInitView()
        lifecycle.addObserver(viewModel)
        viewModel.errorMessage.observe(this) {
            logError(it)
        }
    }
}
