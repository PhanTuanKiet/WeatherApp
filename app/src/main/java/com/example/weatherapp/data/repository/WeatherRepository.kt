package com.example.weatherapp.data.repository

import com.example.weatherapp.network.response.WeatherInfoResponse
import io.reactivex.Observable

interface WeatherRepository {

    fun getWeatherInfo(city: String) : Observable<WeatherInfoResponse>

}