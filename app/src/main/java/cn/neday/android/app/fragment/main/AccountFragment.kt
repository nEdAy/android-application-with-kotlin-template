package cn.neday.android.app.fragment.main

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import cn.neday.android.app.databinding.FragmentAccountBinding
import cn.neday.android.app.viewmodel.HomeViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import cn.neday.base.fragment.launchAndRepeatWithViewLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AccountFragment : BaseBindingVMFragment<FragmentAccountBinding, HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    @SuppressLint("SetTextI18n")
    override fun initView() {
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