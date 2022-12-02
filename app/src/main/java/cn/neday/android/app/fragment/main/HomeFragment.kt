package cn.neday.android.app.fragment.main

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import cn.neday.android.app.R
import cn.neday.android.app.databinding.FragmentHomeBinding
import cn.neday.android.app.viewmodel.HomeViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import cn.neday.base.fragment.launchAndRepeatWithViewLifecycle
import com.dylanc.longan.doOnClick
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : BaseBindingVMFragment<FragmentHomeBinding, HomeViewModel>() {

    override val viewModel by viewModel<HomeViewModel>()

    @SuppressLint("SetTextI18n")
    override fun initView() {
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
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