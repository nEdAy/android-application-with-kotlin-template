package cn.neday.android.business.auth.activity

import android.os.Bundle
import cn.neday.android.business.auth.databinding.ActivityAuthBinding
import cn.neday.base.activity.BaseBindingActivity
import com.therouter.router.Route

@Route(path = "/auth", description = "授权页面")
class AuthActivity : BaseBindingActivity<ActivityAuthBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(binding.toolbar)
    }
}