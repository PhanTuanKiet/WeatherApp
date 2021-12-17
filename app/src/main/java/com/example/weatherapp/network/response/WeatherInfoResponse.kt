package com.example.weatherapp.network.response

import com.example.weatherapp.base.BaseResponse
import com.example.weatherapp.model.City
import com.example.weatherapp.model.WeatherInfo
import com.google.gson.annotations.SerializedName

data class WeatherInfoResponse(
    @SerializedName("cod")
    override var code: String,
    override var message: String,
    val city : City,
    val cnt : Int,
    val list: MutableList<WeatherInfo>?
) : BaseResponse()