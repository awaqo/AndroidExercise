package com.kampusmerdeka.recyclerviewlatihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Images>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
        )

        heading = arrayOf(
            "Latihan Recycler View Kotlin Android Studio Gambar 1",
            "Latihan Recycler View Kotlin Android Studio Gambar 2",
            "Latihan Recycler View Kotlin Android Studio Gambar 3",
            "Latihan Recycler View Kotlin Android Studio Gambar 4"
        )

        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Images>()
        getUserData()
    }

    private  fun getUserData() {
        for (i in imageId.indices){
            val imgs = Images(imageId[i],heading[i])
            newArrayList.add(imgs)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}