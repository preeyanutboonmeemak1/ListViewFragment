package com.preeyanut.listviewfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.Gson
import org.json.JSONObject

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val data = intent.getStringExtra("data")
        val jsondata = JSONObject(data)

        val image: ImageView = findViewById(R.id.about_image)
        val title: TextView = findViewById(R.id.about_title)
        val description: TextView = findViewById(R.id.about_description)

        title.setText(jsondata.getString("title").toString())
        description.setText(jsondata.getString("description").toString())

        Glide.with(this)
            .load(jsondata.getString("image").toString())
            .into(image)
    }
}
