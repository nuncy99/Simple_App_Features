package com.example.alertdialog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val language = arrayOf("English","Hindi","Manipuri","Assamese","Nepali","Spanish","Chinese","Korean","Tamil","Telegu","Bodo","Gujurati","Kannada","Marathi","Oriya","Sanskrit","Santali","Kashmiri")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        val listView = findViewById<ListView>(R.id.list_item)
        val adapter = ArrayAdapter(this,R.layout.listview_item,language)
        listView.adapter = adapter
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val intent = Intent(this@listView,view2::class.java)
                intent.putExtra("EXTRA_WORD",language[position])
                startActivity(intent)
                Toast.makeText(this@listView, "Selected item is "+language[position], Toast.LENGTH_SHORT).show()
            }

        }

    }
}