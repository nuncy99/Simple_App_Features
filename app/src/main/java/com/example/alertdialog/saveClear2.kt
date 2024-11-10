package com.example.alertdialog

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class saveClear2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_save_clear2)


        val editHereBtn = findViewById<Button>(R.id.editHereBtn)
        val editText = findViewById<EditText>(R.id.editTextMessage)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        val textView= findViewById<TextView>(R.id.textView)

        editHereBtn.setOnClickListener {
            editHereBtn.visibility= View.GONE
            //val text=editText.text.toString()
            editText.visibility = View.VISIBLE
            saveBtn.visibility = View.VISIBLE

        }
        //val text=editText.text.toString()
        saveBtn.setOnClickListener {
            val text=editText.text.toString()
            textView.text=text
            editText.visibility= View.GONE
            saveBtn.visibility = View.GONE
            textView.visibility = View.VISIBLE
            editHereBtn.visibility = View.VISIBLE



        }

    }
}