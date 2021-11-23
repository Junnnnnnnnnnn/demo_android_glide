package com.yotdark.example_glide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val glide: GlideActivity by lazy {
        GlideActivity(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        glide.glideLoadImage(image1,"https://image.edaily.co.kr/images/photo/files/NP/S/2019/05/PS19050800712.jpg", "success")
        glide.glideLoadImage(image2,"https://node.com.haha.jpg","loading")
        glide.glideLoadImage(image3,"https://nothing.nothing","false")
    }
}