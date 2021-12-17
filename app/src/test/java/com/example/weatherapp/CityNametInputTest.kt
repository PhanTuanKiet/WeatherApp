package com.example.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.viewmodel.WeatherInfoViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.junit.Assert.*
import org.junit.Rule

class CityNametInputTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repo: WeatherRepository

    @Mock
    lateinit var viewModel: WeatherInfoViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = WeatherInfoViewModel(repo)
    }

    @Test
    fun testCityName_isValid(){
        viewModel.validateCityName("saigon")

        assertEquals(viewModel.isEnableBtnGetWeather.value, true)
    }

    @Test
    fun testCityNameIsLessThan3Chars_isInvalid(){
        viewModel.validateCityName("sa")

        assertEquals(viewModel.isEnableBtnGetWeather.value, false)
    }

    @Test
    fun testCityNameContainsNumber_isInvalid(){
        viewModel.validateCityName("sa1")

        assertEquals(viewModel.isEnableBtnGetWeather.value, false)
    }

    @Test
    fun testCityNameContainsOtherChars_isInvalid(){
        viewModel.validateCityName("sa#")

        assertEquals(viewModel.isEnableBtnGetWeather.value, false)
    }

}