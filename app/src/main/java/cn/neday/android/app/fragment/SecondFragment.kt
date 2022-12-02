package cn.neday.android.app.fragment

import androidx.fragment.app.Fragment
import cn.neday.android.app.databinding.FragmentSecondBinding
import cn.neday.base.fragment.BaseBindingFragment
import com.therouter.TheRouter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseBindingFragment<FragmentSecondBinding>() {

    override fun initView() {
        binding.buttonSecond.setOnClickListener {
            // findNavController().navigate(R.id.action_SecondFragment_to_HomeFragment)
            TheRouter.build("/auth").navigation(this)
        }
    }
}