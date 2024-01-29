package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.DriverFragment
import com.example.myapplication.R
import com.example.myapplication.fragments.RequestsFragment
import com.example.myapplication.fragments.RouteFragment
import com.example.myapplication.fragments.SavedFragment
import com.example.myapplication.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        replaceFragment(DriverFragment())

        bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.route -> replaceFragment(RouteFragment())
                R.id.drive -> replaceFragment(DriverFragment())
                R.id.saved -> replaceFragment(SavedFragment())
                R.id.request -> replaceFragment(RequestsFragment())
                R.id.settings -> replaceFragment(SettingsFragment())

                else ->{  }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}