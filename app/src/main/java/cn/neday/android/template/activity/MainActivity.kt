package cn.neday.android.template.activity

import android.os.Bundle
import cn.neday.android.template.databinding.ActivityMainBinding
import cn.neday.base.activity.BaseBindingActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}