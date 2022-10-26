package com.srj.marvelworld.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(imageUrl : String){
    Glide.with(this.context).load(imageUrl)
        .centerCrop()
        //.placeholder(R.drawable.marvel_logo)
        //.error(R.drawable.ic_error)
        .into(this)
}