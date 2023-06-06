package com.example.finalproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalproject.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragContainer) as NavHostFragment

        navController = navHostFragment.navController
        bottomNav = findViewById(R.id.bottomNav)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.historyNonLoginFragment,
            R.id.notifFragment,
            R.id.akunNonLoginFragment
        ).build()

        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{_,item,_ ->
            when(item.id){
                R.id.homeFragment -> hidebottomNav(false)
                R.id.historyNonLoginFragment -> hidebottomNav(false)
                R.id.notifFragment -> hidebottomNav(false)
                R.id.akunNonLoginFragment -> hidebottomNav(false)
                else -> hidebottomNav(true)
            }

        }

    }

    private fun hidebottomNav(hide: Boolean) {
        if (hide){
            bottomNav.visibility = View.GONE
        }else{
            bottomNav.visibility = View.VISIBLE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}