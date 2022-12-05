package cn.neday.android.app.fragment.main

import cn.neday.android.app.databinding.FragmentAccountBinding
import cn.neday.android.app.viewmodel.AccountViewModel
import cn.neday.android.base.fragment.BaseBindingVMFragment
import cn.neday.android.business.router.BusinessAuthPathIndex
import com.therouter.TheRouter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * AccountFragment
 */
class AccountFragment : BaseBindingVMFragment<FragmentAccountBinding, AccountViewModel>() {

    override val viewModel by viewModel<AccountViewModel>()

    override fun initView() {
        binding.fab.setOnClickListener {
            TheRouter.build(BusinessAuthPathIndex.AuthActivity).navigation()
        }
    }
}