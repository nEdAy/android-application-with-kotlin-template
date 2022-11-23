package cn.neday.android.template.fragment.main

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.FragmentProjectBinding
import cn.neday.android.template.viewmodel.HomeViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import cn.neday.base.fragment.launchAndRepeatWithViewLifecycle
import com.dylanc.longan.doOnClick
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ProjectFragment : BaseBindingVMFragment<FragmentProjectBinding, HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    @SuppressLint("SetTextI18n")
    override fun initView() {
        binding.buttonFirst.doOnClick {
            findNavController().navigate(R.id.action_HomeFragment_to_SecondFragment)
        }
        launchAndRepeatWithViewLifecycle {
            viewModel.sentence.collect {
                binding.tvHitokoto.text = it
            }
        }
        launchAndRepeatWithViewLifecycle {
            viewModel.author.collect {
                binding.tvFrom.text = "—— 「${it}」"
            }
        }
        viewModel.likeInfo.observe(this) {
            binding.likeInfo.text = it.size.toString()
        }
        viewModel.getHitokoto()
    }
}