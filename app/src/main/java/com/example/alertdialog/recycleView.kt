package com.example.alertdialog

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycleView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: Array<Int>
    lateinit var titleList: Array<String>
    lateinit var sNameList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        imageList = arrayOf(
            R.drawable.flower1,
            R.drawable.flower2,
            R.drawable.flower3,
            R.drawable.flower4,
            R.drawable.flower5,
            R.drawable.flower6,
            R.drawable.flower7
           )
        titleList = arrayOf(
            "Sunflower", "Lotus","Rose","Hibiscus","Chrysanthemum","Lily","Carnation"
        )
        sNameList = arrayOf(
            "Helianthus Annuus","Nelumbo Nucifera",
            "Rosa Rubiginosa","Hibiscus Rosa",
            "Dendrathema Grandiflora","Lilium","Dyanthus Caryophyllus"
        )


        recyclerView = findViewById(R.id.recyclerViewId)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()


    }
    private fun getData() {
        for(i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i], sNameList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = AdapterClass(dataList)

    }
}