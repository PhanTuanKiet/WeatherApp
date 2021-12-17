package com.example.weatherapp.model

data class WeatherInfoUI (
    val date : String,
    val avgTemperature : Float,
    val pressure : Int,
    val humidity : Int,
    val description : String)