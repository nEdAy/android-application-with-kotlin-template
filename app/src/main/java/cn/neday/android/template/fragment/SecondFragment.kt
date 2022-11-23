package cn.neday.android.template.fragment

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.FragmentSecondBinding
import cn.neday.base.fragment.BaseBindingFragment

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseBindingFragment<FragmentSecondBinding>() {

    override fun initView() {
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_HomeFragment)
        }
    }
}