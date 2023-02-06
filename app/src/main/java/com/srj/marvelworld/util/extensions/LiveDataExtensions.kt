package com.srj.marvelworld.util.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.srj.marvelworld.util.EventUtil

fun <T> MutableLiveData<EventUtil<T>>.postEvent(content: T) {
    postValue(EventUtil(content))
}

inline fun <T> LiveData<EventUtil<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onEventUnhandledContent: (T) -> Unit
) {
    observe(owner) { it?.getContentIfNotHandled()?.let(onEventUnhandledContent) }
}