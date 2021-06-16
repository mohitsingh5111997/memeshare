package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setImage()

    }

    fun setImage() {

        val queue = Volley.newRequestQueue(this)
        val url = "https://i.redd.it/jk12rq8nrhv51.jpg"
// Instantiate the RequestQueue.
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                Log.d("cheak", "success")
                val url = response.getString("url")

                Glide.with(this).load(url).into(imageView2)
            },
            { error ->
                Log.d("cheak", "Failed")
            }
        )
        queue.add(jsonObjectRequest)
    }

}