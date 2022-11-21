package cn.neday.android.template.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.FragmentMainBinding
import cn.neday.android.template.viewmodel.MainViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : BaseBindingVMFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel by viewModel<MainViewModel>()

    override fun initView() {
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SecondFragment)
        }
        viewModel.getSentence()
    }
}