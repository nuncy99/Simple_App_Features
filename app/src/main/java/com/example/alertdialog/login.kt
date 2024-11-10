package com.example.alertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialog.R.id.login2Btn

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mailFill = findViewById<EditText>(R.id.mail2Text)
        val passFill = findViewById<EditText>(R.id.pwdText)
        val loginBtn = findViewById<Button>(R.id.login2Btn)

        loginBtn.setOnClickListener {
            val mail:String = mailFill.text.toString()
            val password = passFill.text.toString()
            if(mail=="user@example.com" && password=="password")
            {
                Toast.makeText(this@login,"login successful", Toast.LENGTH_SHORT).show()
                mailFill.text=null
                passFill.text= null
                finish()
                val intent = Intent(this@login, loginView::class.java)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this@login,"Invalid Username or Password",Toast.LENGTH_SHORT).show()
            }
        }


    }
}