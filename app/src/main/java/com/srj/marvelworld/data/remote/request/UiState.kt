package com.srj.marvelworld.data.remote.request

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<T>(val responseData: T) : UiState<T>()
    data class Error(val errorMessage: String) : UiState<Nothing>()

    fun toData(): T? = if (this is Success) responseData else null
}
