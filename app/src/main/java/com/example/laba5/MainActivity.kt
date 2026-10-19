package com.example.laba5


import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val images = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setData()

        val recyclerView = findViewById<RecyclerView>(R.id.review1)

        val isTablet = resources.configuration.smallestScreenWidthDp >= 600

        recyclerView.layoutManager = if (isTablet) {
            GridLayoutManager(this, 2)
        } else {
            LinearLayoutManager(this)
        }

        recyclerView.adapter = CustomRecyclerAdapter(this, images)
    }

    private fun setData() {
        val names = resources.getStringArray(R.array.images)

        val descriptions = arrayOf(
            "Изображение 1",
            "Изображение 2",
            "Изображение 3",
            "Изображение 4",
            "Изображение 5",
            "Изображение 6"
        )

        val pictures = intArrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image1,
            R.drawable.image2
        )

        for (i in names.indices) {
            images.add(
                Image(
                    name = names[i],
                    description = descriptions[i],
                    imageRes = pictures[i]
                )
            )
        }
    }
}
