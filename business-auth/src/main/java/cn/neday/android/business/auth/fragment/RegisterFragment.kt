package cn.neday.android.business.auth.fragment

import androidx.navigation.fragment.findNavController
import cn.neday.android.base.fragment.BaseBindingFragment
import cn.neday.android.business.auth.R
import cn.neday.android.business.auth.databinding.FragmentRegisterBinding

class RegisterFragment : BaseBindingFragment<FragmentRegisterBinding>() {

    override fun initView() {
        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_RegisterFragment_to_LoginFragment)
        }
    }
}