package cn.neday.android.template.activity

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.ActivityMainBinding
import cn.neday.base.activity.BaseBindingActivity

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {
        // Handle the splash screen transition.
        val splashScreen = installSplashScreen()

        setSupportActionBar(binding.toolbar)
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        binding.contentMain.bottomNavigation.setupWithNavController(navController.navController)
    }
}