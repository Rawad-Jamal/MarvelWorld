package com.srj.marvelworld.ui.main

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.srj.marvelworld.R
import com.srj.marvelworld.databinding.ActivityMainBinding
import com.srj.marvelworld.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onResume() {
        super.onResume()
        val navController = findNavController(R.id.fragment_container)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    fun setBottomNavigationVisibility(visibility: Int) {
        binding.bottomNavigation.visibility = visibility
    }

}