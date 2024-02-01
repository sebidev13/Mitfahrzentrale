package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.activities.MainActivity
import com.example.myapplication.adapters.RequestAdapter

class SettingsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logout_btn = view.findViewById<Button>(R.id.logout)
        logout_btn.setOnClickListener{
            Constants.CURRENT_USER = null
            activity?.finish()
        }

    }

}