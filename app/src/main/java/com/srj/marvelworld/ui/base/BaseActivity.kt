package com.srj.marvelworld.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB : ViewDataBinding>(private val layoutId: Int):
    AppCompatActivity() {

    private lateinit var _binding: VDB
    val binding: VDB
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this@BaseActivity, layoutId)
    }
}