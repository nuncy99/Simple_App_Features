package com.example.alertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val alertBtnDialog = findViewById<Button>(R.id.button)
        val listBtn = findViewById<Button>(R.id.button3)
        //val seekBtn = findViewById<Button>(R.id.button4)
        val registerBtn = findViewById<Button>(R.id.button5)
        val toastSnack = findViewById<Button>(R.id.button6)
        val recycleBtn = findViewById<Button>(R.id.button7)
        val saveClearBtn = findViewById<Button>(R.id.button8)
        val webViewBtn = findViewById<Button>(R.id.button9)
        val cameraBtn = findViewById<Button>(R.id.button10)
        val displayPhotoBtn = findViewById<Button>(R.id.button11)
        val notificationBtn = findViewById<Button>(R.id.button12)
        val customAlertDialogBtn = findViewById<Button>(R.id.button13)
        val finalregistrationBtn = findViewById<Button>(R.id.button14)

        alertBtnDialog.setOnClickListener {
            val intent = Intent(this@MainActivity, alertActivity::class.java)
            startActivity(intent)
        }



        listBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, listView::class.java)
            startActivity(intent)
        }

        /*seekBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, seekBar::class.java)
            startActivity(intent)
        }*/

        registerBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, registration::class.java)
            startActivity(intent)
        }

        addBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, addNumber::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, login::class.java)
            startActivity(intent)
        }

        toastSnack.setOnClickListener {
            val intent = Intent(this@MainActivity, toastSnackBar::class.java)
            startActivity(intent)
        }

        recycleBtn.setOnClickListener {
            val intent= Intent(this@MainActivity,recycleView::class.java)
            startActivity(intent)
        }

        saveClearBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, saveClear::class.java)
            startActivity(intent)
        }

        webViewBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, webView::class.java)
            startActivity(intent)
        }
        cameraBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, cameraView::class.java)
            startActivity(intent)
        }

        displayPhotoBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, displayPhoto::class.java)
            startActivity(intent)
        }

        notificationBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, generateNotification::class.java)
            startActivity(intent)
        }

        customAlertDialogBtn.setOnClickListener {
            val intent = Intent (this@MainActivity, alertDialogCustom::class.java)
            startActivity(intent)
        }

        finalregistrationBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, finalRegistration::class.java)
            startActivity(intent)
        }
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showConfirmExitDialog()
            }
        }


        onBackPressedDispatcher.addCallback(this, callback)
    }
    private fun showConfirmExitDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Exit App?")
        builder.setMessage("Are you sure you want to exit the App?")
        builder.setPositiveButton("OK") { dialog, which ->
            finishAffinity()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
    }
}

