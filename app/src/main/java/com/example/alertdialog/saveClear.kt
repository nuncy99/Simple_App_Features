package com.example.alertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class saveClear : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_save_clear)

        val message = findViewById<EditText>(R.id.textMessage)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val displayBtn = findViewById<Button>(R.id.displayBtn)
        val displayText = findViewById<TextView>(R.id.viewTextMessage)
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)

        val nextActivityBtn = findViewById<Button>(R.id.nexActivityButton)
        val editor = sharedPreferences.edit()
        saveBtn.setOnClickListener {


            //add data
            editor.putString("message",message.text.toString())
            editor.apply()
            message.setText("")
        }

        displayBtn.setOnClickListener {
            val readMessage = sharedPreferences.getString("message","")
            displayText.setText(readMessage)
        }

        clearBtn.setOnClickListener {
            editor.remove("message")
            editor.apply()
        }

        nextActivityBtn.setOnClickListener {
            val intent = Intent(this@saveClear, saveClear2::class.java)
            startActivity(intent)
        }

        }
    }
