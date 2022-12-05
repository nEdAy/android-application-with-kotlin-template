package cn.neday.android.business.auth.fragment

import androidx.navigation.fragment.findNavController
import cn.neday.android.base.fragment.BaseBindingFragment
import cn.neday.android.business.auth.R
import cn.neday.android.business.auth.databinding.FragmentLoginBinding

class LoginFragment : BaseBindingFragment<FragmentLoginBinding>() {

    override fun initView() {
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }
    }
}