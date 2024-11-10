package com.example.alertdialog

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private fun SeekBar.setOnClickListener(onSeekBarChangeListener: SeekBar.OnSeekBarChangeListener) {

}

class alertActivity : AppCompatActivity() {

    var lastSelectedPosition = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val showDialogBtn = findViewById<Button>(R.id.button2)

        var range = findViewById<TextView>(R.id.viewRange)
        val seekBar = findViewById<SeekBar>(R.id.seekBar)

        val cities = arrayOf("Goa", "Agra", "Delhi", "Jaipur", "Chennai")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val arrayAdapter = ArrayAdapter<String>(this, R.layout.spinner_item, cities)


        showDialogBtn.setOnClickListener {
            showAlertDialog()
        }

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != lastSelectedPosition) {
                    Toast.makeText(
                        applicationContext,
                        "Selected city is " + cities[position],
                        Toast.LENGTH_SHORT
                    ).show()
                    lastSelectedPosition = position


                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                range.text = progress.toString()
                // Toast.makeText(this@seekBar, "the progress is "+progress.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }

    private fun showAlertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Alert !")
        builder.setMessage("This is an Alert Dialog ...")
        builder.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@alertActivity, "Positive button clicked", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Dismiss") { dialog, which ->
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            Toast.makeText(this@alertActivity, "Negative button clicked", Toast.LENGTH_SHORT).show()
        }
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
    }
}



