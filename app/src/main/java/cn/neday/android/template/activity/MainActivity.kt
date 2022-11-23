package cn.neday.android.template.activity

import android.os.Bundle
import cn.neday.android.template.databinding.ActivityMainBinding
import cn.neday.base.activity.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(binding.toolbar)
    }
}