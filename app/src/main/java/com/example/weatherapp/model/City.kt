package com.example.weatherapp.model

data class City(
    val id : Long,
    val name : String,
    val coord : Coordinate,
    val country : String,
    val population : Long,
    val timezone : Long
    )
