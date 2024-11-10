package com.example.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        val name = findViewById<EditText>(R.id.nameText)
        val email = findViewById<EditText>(R.id.emailText)
        val password = findViewById<EditText>(R.id.passwordText)
        val address = findViewById<EditText>(R.id.adressText)
        val gender = findViewById<RadioGroup>(R.id.genderButton)

        val submitBtn = findViewById<Button>(R.id.submitButton)
        val showText = findViewById<TextView>(R.id.viewFinalText)
        submitBtn.setOnClickListener {

            val text1 = name.text.toString()
            val text2 = email.text.toString()
            val text3 = password.text.toString()
            val text4 = address.text.toString()

            var selectedGender: String
            val selectedGenderId = gender.checkedRadioButtonId
            if (selectedGenderId != -1) {
                val selectedRadioBtn = findViewById<RadioButton>(selectedGenderId)
                  selectedGender = selectedRadioBtn.text.toString()
            } else {
                  selectedGender ="No Gender Selected"
            }




            val mergeText = "$text1, $text2, $text3, $selectedGender, $text4"

            showText.text = mergeText
        }    }
}
