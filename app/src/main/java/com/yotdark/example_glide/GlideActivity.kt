package com.yotdark.example_glide

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.target.Target

@GlideModule
class GlideActivity(private val context: Context): AppGlideModule() {

    fun glideLoadImage(view: ImageView, url: String, type: String){
        when(type){
            "loading" -> Glide.with(context).load(url).placeholder(getProgress()).into(view)
            else -> Glide.with(context).load(url).placeholder(getProgress()).centerCrop().error(R.drawable.warn_icon_24).into(view)
        }
    }

    private fun getProgress() = CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}