package com.example.weatherapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.weatherapp.databinding.WeatherInfoItemBinding
import com.example.weatherapp.base.BaseAdapter
import com.example.weatherapp.base.BaseViewHolder
import com.example.weatherapp.ui.holder.WeatherInfoHolder

class WeatherInfoAdapter : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = WeatherInfoItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return WeatherInfoHolder(binding)
    }
}