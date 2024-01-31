package com.example.myapplication.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user_input = findViewById<EditText>(R.id.userInput)
        val user_txt: String = user_input.text.toString()

        val pwd_input = findViewById<EditText>(R.id.passwordInput)
        val pwd_txt: String = pwd_input.text.toString()

        val login_btn = findViewById<Button>(R.id.login)

        login_btn.setOnClickListener{
           /* val call = RetrofitClient.apiService.getUserByName(user_txt)

            HelperClass.ApiHelper.getApiResponse(call,
                onSuccess = { response ->
                    if(response.username.equals(user_txt)
                        && response.password.equals(pwd_txt)){
                        Constants.CURRENT_USER = response */
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                   /* }
                },
                onFailure = { t ->
                    Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_LONG ).show()
                }
            ) */
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