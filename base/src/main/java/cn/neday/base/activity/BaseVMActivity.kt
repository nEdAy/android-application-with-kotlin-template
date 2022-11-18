package cn.neday.base.activity

import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import cn.neday.base.viewmodel.BaseViewModel
import com.blankj.utilcode.util.LogUtils

/**
 * Activity基类 + ViewModel
 *
 * @author nEdAy
 */
abstract class BaseVMActivity<VB : ViewBinding, ViewModel : BaseViewModel> :
    BaseActivity<VB>() {

    protected abstract val mViewModel: ViewModel

    override fun prepareInitView() {
        super.prepareInitView()
        lifecycle.addObserver(mViewModel)
        mViewModel.errMsg.observe(this, Observer {
            LogUtils.e(it)
        })
    }
}