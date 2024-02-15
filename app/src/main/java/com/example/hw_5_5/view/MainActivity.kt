package com.example.hw_5_5.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hw_5_5.R
import com.example.hw_5_5.databinding.ActivityMain2Binding
import com.example.hw_5_5.data.local.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var pref: Pref
    private lateinit var binding: ActivityMain2Binding
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        if (!pref.isShow()) {
            navController?.navigate(R.id.onBoardingFragment)

            with(animationView){
                setMainAndMaxFrame(30,50)

            }

        }
    }
}