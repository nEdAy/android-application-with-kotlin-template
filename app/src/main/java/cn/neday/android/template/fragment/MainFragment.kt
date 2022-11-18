package cn.neday.android.template.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.FragmentMainBinding
import cn.neday.android.template.viewmodel.MainViewModel
import cn.neday.base.fragment.BaseVMFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : BaseVMFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel by viewModel<MainViewModel>()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun initView() {
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SecondFragment)
        }
    }
}