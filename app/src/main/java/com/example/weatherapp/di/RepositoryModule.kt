package com.example.weatherapp.di

import com.example.weatherapp.data.repository.WeatherInfoRepoImpl
import com.example.weatherapp.data.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun getWeatherInfoRepo(repo : WeatherInfoRepoImpl) : WeatherRepository


}