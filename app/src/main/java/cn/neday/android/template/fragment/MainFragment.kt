package cn.neday.android.template.fragment

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.FragmentMainBinding
import cn.neday.android.template.viewmodel.MainViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import cn.neday.base.fragment.launchAndRepeatWithViewLifecycle
import com.dylanc.longan.doOnClick
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : BaseBindingVMFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel by viewModel<MainViewModel>()

    @SuppressLint("SetTextI18n")
    override fun initView() {
        binding.buttonFirst.doOnClick {
            findNavController().navigate(R.id.action_MainFragment_to_SecondFragment)
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