package com.srj.marvelworld.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.srj.marvelworld.data.remote.request.UiState
import com.srj.marvelworld.ui.base.BaseAdapter
import com.srj.marvelworld.util.extensions.hideView
import com.srj.marvelworld.util.extensions.loadImageUrl
import com.srj.marvelworld.util.extensions.showView

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter  as BaseAdapter<T>?)?.setItems(items?: emptyList())
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: UiState<T>?){
    if(state is UiState.Loading){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: UiState<T>?){
    if(state is UiState.Success){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: UiState<T>?){
    if(state is UiState.Error){
        view.showView()
    } else {
        view.hideView() }
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageByUrl(view: ImageView, url: String?){
    if (url != null) {
        with(view) { loadImageUrl(url) }
    }
}
