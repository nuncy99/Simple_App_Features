package com.example.alertdialog

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.Manifest
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class displayPhoto : AppCompatActivity() {

    private lateinit var imageView: ImageView

    private val galleryLacher =  registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if ( result.resultCode == Activity.RESULT_OK) {
            val imageUri: Uri? = result.data?.data
            imageView.setImageURI(imageUri)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display_photo)

        val displayImageBtn = findViewById<Button>(R.id.selectPhotoBtn)
        imageView = findViewById(R.id.imageDisplay)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
            )

        }
        displayImageBtn.setOnClickListener {
            openGallery()
        }
    }

        private fun openGallery() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLacher.launch(intent)
        }


}