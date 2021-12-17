package com.example.weatherapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.R
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.model.WeatherInfo
import com.example.weatherapp.model.WeatherInfoUI
import com.example.weatherapp.base.BaseViewModel
import com.example.weatherapp.utils.DateTimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class WeatherInfoViewModel @Inject constructor(
    private val repo: WeatherRepository
) : BaseViewModel() {

    private var inputErrorMessage: Int = 0

    val inputValidateMessageLive: MutableLiveData<Int> by lazy {
        MutableLiveData()
    }

    val isEnableBtnGetWeather: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }

    val weatherResultData: MutableLiveData<List<WeatherInfoUI>?> by lazy {
        MutableLiveData(null)
    }

    fun validateCityName(text: String? = null) {
        var isTextValid = false
        if (text!!.length < 3) {
            inputErrorMessage = R.string.city_name_must_be_more_than_3_characters
        } else if (!text.matches(Regex("[a-zA-Z]+"))){
            inputErrorMessage = R.string.city_name_should_only_contains_alphabet_characters
        }
        else {
            isTextValid = true
            inputErrorMessage = R.string.empty
        }

        updateValidateError()
        isEnableBtnGetWeather.value = isTextValid
    }

    private fun updateValidateError() {
        inputValidateMessageLive.value = inputErrorMessage
    }


    fun getWeatherInfo(cityName: String) {
        val result = repo.getWeatherInfo(cityName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { response ->
                    convertWeatherInfoUI(response.list)
                },
                { throwable ->
                    handleError(throwable)
                }
            )
        compositeDisposable.add(result)

    }

    private fun convertWeatherInfoUI(listData: MutableList<WeatherInfo>?) {
        val allInfo = mutableListOf<WeatherInfoUI>()
        if (!listData.isNullOrEmpty()){
            for (i in 0 until listData.size) {
                val info = listData[i]
                val date = DateTimeUtils.convertMillisecondToDate(info.dt)
                val avgTemp = info.temperature.day
                val pressure = info.pressure
                val humidity = info.humidity
                val description = info.weather[0].description
                val day = WeatherInfoUI(
                    date = date,
                    avgTemperature = avgTemp,
                    pressure = pressure,
                    humidity = humidity,
                    description = description
                )
                allInfo.add(day)
            }
        }
        updateWeatherResult(allInfo)
    }

    private fun updateWeatherResult(listData: MutableList<WeatherInfoUI>){
        if (weatherResultData.value != listData) {
            weatherResultData.value = listData
        }
    }


}