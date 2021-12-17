package com.example.weatherapp.data.remote

import com.example.weatherapp.network.ApiService
import com.example.weatherapp.network.response.WeatherInfoResponse
import io.reactivex.Observable
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getWeatherInfo(cityName : String) : Observable<WeatherInfoResponse> {
        return apiService.getWeatherInfo(cityName)
    }

}