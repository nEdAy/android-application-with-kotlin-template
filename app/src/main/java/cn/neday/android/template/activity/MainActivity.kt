package cn.neday.android.template.activity

import android.os.Bundle
import cn.neday.android.template.R
import cn.neday.android.template.fragment.MainFragment
import cn.neday.base.activity.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_main) {
    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}