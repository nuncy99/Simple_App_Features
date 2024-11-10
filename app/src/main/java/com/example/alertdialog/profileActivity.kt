package com.example.alertdialog

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class profileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val getEmail=intent.getStringExtra("email")
        val getPassword = intent.getStringExtra("password")
        val getname = intent.getStringExtra("name")
        val getdob =intent.getStringExtra("dob")
        val getgender = intent.getStringExtra("gender")


        val name=findViewById<TextView>(R.id.nameText)
        val dob=findViewById<TextView>(R.id.dobText)
        val gender=findViewById<TextView>(R.id.genderText)
        val email=findViewById<TextView>(R.id.emailText)

        name.setText("  NAME - "+getname)
        dob.setText("  DATE OF BIRTH - "+getdob)
        gender.setText("  GENDER - "+getgender)
        email.setText("  EMAIL ID - "+getEmail)




    }
}