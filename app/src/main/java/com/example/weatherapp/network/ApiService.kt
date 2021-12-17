package com.example.weatherapp.network

import com.example.weatherapp.network.response.WeatherInfoResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("daily")
    fun getWeatherInfo(
        @Query("q") cityName : String,
        @Query("cnt") numberOfDay : Int? = 7,
        @Query("appid") appId :String? = "60c6fbeb4b93ac653c492ba806fc346d",
        @Query("units") unit :String? = "metric"
    ): Observable<WeatherInfoResponse>

}