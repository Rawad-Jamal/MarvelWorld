package com.srj.marvelworld.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.srj.marvelworld.R

fun ImageView.loadImageUrl(imageUrl : String){
    Glide.with(this.context).load(imageUrl)
        .centerCrop()
        .placeholder(R.drawable.rotate)
        .error(R.drawable.marvel_logo)
        .into(this)
}