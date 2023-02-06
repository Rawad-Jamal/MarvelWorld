package com.srj.marvelworld.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srj.marvelworld.BR
import com.srj.marvelworld.ui.main.MainActivity

abstract class BaseFragment<VDB : ViewDataBinding, VM : ViewModel>(@LayoutRes private val layoutId: Int) :
    Fragment() {

    lateinit var viewModel: VM
    abstract val viewModelClass: Class<VM>
    protected open var bottomNavigationViewVisibility = View.VISIBLE

    private lateinit var _binding: VDB
    val binding: VDB
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        setBottomNavigationVisibilityValue()
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        _binding.apply {
            setVariable(BR.viewModel, this@BaseFragment.viewModel)
            lifecycleOwner = this@BaseFragment
            return root
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[viewModelClass]
    }

    private fun setBottomNavigationVisibilityValue() {
        if (activity is MainActivity) {
            (activity as MainActivity).setBottomNavigationVisibility(bottomNavigationViewVisibility)
        }
    }
}