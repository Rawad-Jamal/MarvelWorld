package com.srj.marvelworld.util.extensions

import android.view.View

fun View.hideView(){
    this.visibility = View.GONE
}

fun View.showView(){
    this.visibility = View.VISIBLE
}