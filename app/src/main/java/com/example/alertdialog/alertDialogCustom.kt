package com.example.alertdialog

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class alertDialogCustom : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_dialog_custom)


        showCustomDialog()

    }
    private fun showCustomDialog() {
        // Create an AlertDialog builder
        val builder = AlertDialog.Builder(this)

        // Inflate the custom layout with EditText and Button
        val dialogLayout = layoutInflater.inflate(R.layout.alert_custom, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.alert_message)

        // Set the custom layout as the AlertDialog view
        builder.setView(dialogLayout)

        // Create and display the AlertDialog
        val dialog = builder.create()

        // Find and set an OnClickListener to the Button in the custom layout
        dialogLayout.findViewById<Button>(R.id.submit_message).setOnClickListener {
            // Get the text from EditText
            val inputText = editText.text.toString()

            // Display the text in a Toast
            Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()

            // Dismiss the dialog
            dialog.dismiss()
        }
        // Show the dialog
        dialog.show()
    }

}