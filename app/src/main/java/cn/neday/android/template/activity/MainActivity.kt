package cn.neday.android.template.activity

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import cn.neday.android.template.R
import cn.neday.android.template.databinding.ActivityMainBinding
import cn.neday.base.activity.BaseBindingActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun initView(savedInstanceState: Bundle?) {
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}