package cn.neday.base.fragment

import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import cn.neday.base.viewmodel.BaseViewModel
import com.blankj.utilcode.util.LogUtils

/**
 * Fragment基类 + ViewModel
 *
 * @author nEdAy
 */
abstract class BaseVMFragment<VB : ViewBinding, VM : BaseViewModel> : BaseFragment<VB>() {

    protected abstract val viewModel: VM

    override fun prepareInitView() {
        super.prepareInitView()
        lifecycle.addObserver(viewModel)
        viewModel.errMsg.observe(this, Observer {
            LogUtils.e(it)
        })
    }
}
