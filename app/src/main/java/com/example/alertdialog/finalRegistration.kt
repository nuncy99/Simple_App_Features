package com.example.alertdialog

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.DatePickerDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class finalRegistration : AppCompatActivity() {



    private lateinit var selectedDateText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_registration)

       val nameText = findViewById<EditText>(R.id.nameText)
       val selectDateBtn = findViewById<Button>(R.id.selectDateText)
       selectedDateText = findViewById(R.id.dateText)
       val emailText = findViewById<EditText>(R.id.emailText)
       val passwordText = findViewById<EditText>(R.id.passwordText)
       val confirmPasswordText = findViewById<EditText>(R.id.confirmPasText)
       val saveButton = findViewById<Button>(R.id.saveBtn)

        //Spinner for Selecting Gender
        val spinner = findViewById<Spinner>(R.id.spinnerGender)

        val goToLoginBtn = findViewById<TextView>(R.id.goToLogin)

        //Using shared Preferences for saving data
        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit() //shared preferences requires the use of editor





        spinner.prompt="Select Gender"
        val gender = arrayOf("GENDER","MALE", "FEMALE", "OTHERS")
        val arrayAdapter = ArrayAdapter<String>(this, R.layout.spinner_item, gender)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //Selecting the DATE
        selectDateBtn.setOnClickListener {
            showDatePickerDialog()
        }

        //save Buttom
        saveButton.setOnClickListener {
            val password = passwordText.text.toString()
            val confirmPasswrd = confirmPasswordText.text.toString()
            val name = nameText.text.toString()
            val email = emailText.text.toString()

            if (name.isEmpty()) {
                nameText.error = "Please enter your name"
            } else if (selectedDateText.text.toString() == "SELECT A DATE") {
                Toast.makeText(this, "Date has not been selected!", Toast.LENGTH_SHORT).show()
            } else if (spinner.selectedItem.toString() == "GENDER") {
                Toast.makeText(this, "Please select your Gender", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty()) {
                emailText.error = "Please enter your Email ID"
            } else if (password.isEmpty()) {
                passwordText.error = "Password if Empty"
            } else if (confirmPasswrd.isEmpty()) {
                confirmPasswordText.error = "Please Confirm your Password"
            } else if (password != confirmPasswrd) {
                confirmPasswordText.error = "Password do not match"
            } else {
                //saving the data in sharedPreference
                editor.putString("name", name)
                editor.apply()
                editor.putString("DOB", selectedDateText.text.toString())
                editor.apply()
                editor.putString("gender", spinner.selectedItem.toString())
                editor.apply()
                editor.putString("email", email)
                editor.apply()
                editor.putString("password", password)
                Toast.makeText(
                    this,
                    "Your details have been saved successfully!",
                    Toast.LENGTH_SHORT
                )
                    .show()
                goToLoginBtn.visibility = View.VISIBLE

                goToLoginBtn.setOnClickListener {
                    val intent = Intent(this@finalRegistration, loginAfterRegistration::class.java)
                    intent.putExtra("name", sharedPreferences.getString("name", ""))
                    intent.putExtra("dob", sharedPreferences.getString("DOB", ""))
                    intent.putExtra("gender", sharedPreferences.getString("gender", ""))
                    intent.putExtra("email", sharedPreferences.getString("email", ""))
                    intent.putExtra("password", sharedPreferences.getString("password", ""))

                    startActivity(intent)
                }
            }

        }
            /*goToLoginBtn.setOnClickListener {
            val intent = Intent(this@finalRegistration,loginAfterRegistration::class.java)
            intent.putExtra("name",nameText.text.toString())
            intent.putExtra("dob",selectedDateText.text.toString())
            intent.putExtra("gender",spinner.selectedItem.toString())
            intent.putExtra("email",emailText.text.toString())
            intent.putExtra("password",passwordText.text.toString()
            startActivity(intent)
           }*/

        }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Initialize DatePickerDialog and set a listener to handle the selected date
        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDay ->
                // Update the TextView with the selected date
                val formattedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                selectedDateText.text = formattedDate
            },
            year,
            month,
            day
        )

        // Show the DatePickerDialog
        datePickerDialog.show()
    }

}
