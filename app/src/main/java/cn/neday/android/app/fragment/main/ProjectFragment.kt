package cn.neday.android.app.fragment.main

import android.annotation.SuppressLint
import cn.neday.android.app.databinding.FragmentProjectBinding
import cn.neday.android.app.viewmodel.ProjectViewModel
import cn.neday.base.fragment.BaseBindingVMFragment
import cn.neday.base.fragment.launchAndRepeatWithViewLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * ProjectFragment
 */
class ProjectFragment : BaseBindingVMFragment<FragmentProjectBinding, ProjectViewModel>() {

    override val viewModel by viewModel<ProjectViewModel>()

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