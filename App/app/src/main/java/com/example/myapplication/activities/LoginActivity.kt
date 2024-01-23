package com.example.myapplication.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Constants
import com.example.myapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO: Texte an Service übergeben
        val user_input = findViewById<EditText>(R.id.userInput)
        val user_txt: String = user_input.text.toString()

        val pwd_input = findViewById<EditText>(R.id.passwordInput)
        val pwd_txt: String = pwd_input.text.toString()

        //TODO: Prüfung für Logindaten hinzufügen und ggf. user an intent übergeben
        val login_btn = findViewById<Button>(R.id.login)
        login_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val register_btn = findViewById<Button>(R.id.register)
        register_btn.setOnClickListener{
            val url = Constants.REGISTRATION_URI
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


    }
}