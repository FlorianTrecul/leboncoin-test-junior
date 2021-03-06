package com.floriantrecul.leboncointestjunior.util

sealed class Resource<out T : Any> {
    object Empty : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val title: Int?, val message: Int?) : Resource<Nothing>()


    val extractData: T?
        get() = when (this) {
            is Empty -> null
            is Loading -> null
            is Success -> data
            is Error -> null
        }
}