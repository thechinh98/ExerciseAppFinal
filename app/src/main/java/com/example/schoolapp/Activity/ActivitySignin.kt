package com.example.schoolapp.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.schoolapp.R
import kotlinx.android.synthetic.main.activity_signin.*

class ActivitySignin : AppCompatActivity() {
    var PRIVATE_MODE = 0
    private val PREF_NAME = "USER_DATA"
    private val KEY_NAME = "Email"
    private var KEY_PASSWORD ="Password"

    override fun onCreate(savedInstanceState: Bundle?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        var signUpIntent = Intent(this, ActivitySignup:: class.java)
        var tempIntent = getIntent()
        var sharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        val intent = Intent(this, ActivityMain::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        var emailInput = findViewById<EditText>(R.id.etxt_email_signin)
        val passwordInput = findViewById<EditText>(R.id.etxt_password_signin)

        var tempEmail: String? = tempIntent.getStringExtra("new_email")
        var tempPassword: String? = tempIntent.getStringExtra("new_password")
        var saveEmail = sharedPreferences.getString(KEY_NAME,null)
        var savePass = sharedPreferences.getString(KEY_PASSWORD,null)
        if(tempEmail != ""){
            emailInput.setText(tempEmail)
            passwordInput.setText(tempPassword)
        }
        btn_signup.setOnClickListener {
            startActivity(signUpIntent)
        }
        txt_fgt_pass.setOnClickListener{
            startActivity(browserIntent)
        }
        btn_signin.setOnClickListener{
            var emailLogIn = emailInput.text.toString()
            var passwordLogin = passwordInput.text.toString()
            if(emailLogIn.equals(saveEmail) && passwordLogin.equals(savePass)) {
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
