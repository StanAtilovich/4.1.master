package ru.stan.a41.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import ru.stan.a41.R
import ru.stan.a41.databinding.ActivityMainBinding
import ru.stan.a41.databinding.ActivityMainWithDrawerBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainWithDrawerBinding
    private lateinit var  navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWithDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        binding.activityMain.navView.setupWithNavController(navController)

        binding.drawerNavView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.sing_up -> {
                    Toast.makeText(this, "SingUp", Toast.LENGTH_SHORT).show()
                }

                R.id.sing_in -> {
                    Toast.makeText(this, "SingIn", Toast.LENGTH_SHORT).show()
                }

                R.id.sing_out -> {
                    Toast.makeText(this, "SingOut", Toast.LENGTH_SHORT).show()
                }
            }

            binding.drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }


    }



}