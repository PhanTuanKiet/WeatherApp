package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.RemoteDataSource

import com.example.weatherapp.network.response.WeatherInfoResponse
import io.reactivex.Observable
import javax.inject.Inject

class WeatherInfoRepoImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : WeatherRepository {

    override fun getWeatherInfo(city: String): Observable<WeatherInfoResponse> {
        return remoteDataSource.getWeatherInfo(city)
    }


}