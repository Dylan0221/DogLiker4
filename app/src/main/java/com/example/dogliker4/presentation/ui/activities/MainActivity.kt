package com.example.dogliker4.presentation.ui.activities

import android.content.ContentValues.TAG
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.dogliker4.R
import com.example.dogliker4.databinding.ActivityMainBinding
import com.example.dogliker4.presentation.viewmodel.sharedviewmodel.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: main activity")


        val viewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController((R.id.fragmentContainerView))
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.likedDogsFragment))
        bottomNavigationView.setupWithNavController(navController)



    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        Log.d(TAG, "onCreateView: main activity")


        return super.onCreateView(name, context, attrs)


    }
}