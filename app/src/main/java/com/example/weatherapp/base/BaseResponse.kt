package com.example.weatherapp.base

import com.google.gson.annotations.SerializedName

abstract class BaseResponse {
    abstract var code: String
    abstract var message: String
}