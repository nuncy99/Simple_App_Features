package com.example.alertdialog

import android.app.ProgressDialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class toastSnackBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_toast_snack_bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val messages = findViewById<EditText>(R.id.messageText)
        val toastBtn = findViewById<Button>(R.id.toast)
        val snackBtn = findViewById<Button>(R.id.snackBar)

        //Display progress Dialog
        val showProgressDialogBtn = findViewById<Button>(R.id.progressBtn)

        showProgressDialogBtn.setOnClickListener {
            showProgressDialog()
        }

        toastBtn.setOnClickListener {
            Toast.makeText(this@toastSnackBar,messages.getText().toString(),Toast.LENGTH_SHORT).show()
        }

        snackBtn.setOnClickListener {
            val snackbar = Snackbar.make(it, messages.getText().toString(), Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null)
                    snackbar.setActionTextColor(Color.BLACK)
                    snackbar.setAction("cancel") {

                    }

                    val snackbarView=snackbar.view
                    snackbarView.setBackgroundColor(Color.BLACK)
                    snackbar.show()
        }
    }
    private fun showProgressDialog() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading, please wait ...")
        progressDialog.setCancelable(false) //prevent dismiss by touch outside
        progressDialog.show()

        Handler().postDelayed({
            if (progressDialog.isShowing) {
                progressDialog.dismiss()
            }
        },3000)
    }
}