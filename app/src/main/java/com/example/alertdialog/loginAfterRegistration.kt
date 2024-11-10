package com.example.alertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginAfterRegistration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_after_registration)

        val email = findViewById<EditText>(R.id.emailIdTextLogin)
        val password = findViewById<EditText>(R.id.passwordTextLogin)
        val signUpBtn = findViewById<Button>(R.id.signUp)

        val getEmail=intent.getStringExtra("email")
        val getPassword = intent.getStringExtra("password")
        val name = intent.getStringExtra("name")
        val dob =intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")



        signUpBtn.setOnClickListener {

            if(email.text.toString()!=getEmail) {
                email.error ="Incorrect Email ID"
            }
            else if (password.text.toString()!=getPassword) {
                password.error = "Incorrect password"
            }
            else {
                val intent =Intent(this@loginAfterRegistration,profileActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("dob", dob)
                intent.putExtra("gender",gender)
                intent.putExtra("email", getEmail)
                startActivity(intent)
            }

        }








    }
}