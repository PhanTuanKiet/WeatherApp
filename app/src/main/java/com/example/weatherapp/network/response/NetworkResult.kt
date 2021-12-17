package com.example.weatherapp.network.response

open class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {

}