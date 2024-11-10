package com.example.alertdialog

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class addNumber : AppCompatActivity(), View.OnClickListener {

    lateinit var editTextName1: EditText
    lateinit var editTextName2: EditText
    lateinit var buttonClick: Button
    lateinit var textViewMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_number)

        editTextName1 = findViewById(R.id.numText1)
        editTextName1.inputType = InputType.TYPE_CLASS_NUMBER
        editTextName2 = findViewById(R.id.numText2)
        editTextName2.inputType = InputType.TYPE_CLASS_NUMBER

        buttonClick = findViewById(R.id.addButton)
        textViewMessage = findViewById(R.id.textViewMessage)
        buttonClick.setOnClickListener(this)
    }

    private fun addNumbers() {
        //get the text froM EditText text.toString()
        val text1 = editTextName1.text.toString()
        val text2 = editTextName2.text.toString()

        //Convertiing to Number
        val num1 = text1.toInt()
        val num2 = text2.toInt()

        //Add the numbers
        val sum = num1 + num2

        //Displaying the result
        textViewMessage.text = "Sum: $sum"

    }

    override fun onClick(v: View?) {
        addNumbers()
    }

}



