package com.example.schoolapp.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.activity_signup.*

class ActivitySignup : AppCompatActivity() {
    var PRIVATE_MODE = 0
    private val PREF_NAME = "USER_DATA"
    private val KEY_NAME = "Email"
    private var KEY_PASSWORD ="Password"
    override fun onCreate(savedInstanceState: Bundle?) {
        var sharePreference :SharedPreferences = getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        val editor = sharePreference.edit()
        var intent = Intent(this, ActivitySignin:: class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btn_signin.setOnClickListener{
            startActivity(intent)
        }

        btn_signup.setOnClickListener{
            val emailView = findViewById<TextView>(R.id.etxt_email_signup)
            val passView = findViewById<TextView>(R.id.etxt_password_signin)

            var emailNew : String = emailView.text.toString()
            var passNew : String = passView.text.toString()
            if(emailNew != ""&& passNew != "") {
                intent.putExtra("new_email", emailNew)
                intent.putExtra("new_password", passNew)
                editor.putString(KEY_NAME, emailNew)
                editor.putString(KEY_PASSWORD, passNew)
                editor.commit()
                startActivity(intent)
                Toast.makeText(this, "Registration successfully", Toast.LENGTH_SHORT).show()
                finish()

            } else {
                Toast.makeText(this, "Please input correct information", Toast.LENGTH_LONG).show()
            }
        }
    }

}
