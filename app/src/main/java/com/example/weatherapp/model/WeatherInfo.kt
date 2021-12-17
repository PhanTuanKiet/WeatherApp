package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo (
    val dt : Long,
    val sunrise : Long,
    val sunset : Long,
    @SerializedName("temp")
    val temperature: Temperature,
    @SerializedName("feel_like")
    val feelLike: Temperature,
    val pressure : Int,
    val humidity : Int,
    val weather : MutableList<Weather>,
    val speed : Float,
    val deg : Int,
    val gust : Float,
    val clouds : Float,
    val pop : Float
    )