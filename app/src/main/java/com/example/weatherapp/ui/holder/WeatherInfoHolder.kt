package com.example.weatherapp.ui.holder

import com.example.weatherapp.R
import com.example.weatherapp.databinding.WeatherInfoItemBinding
import com.example.weatherapp.model.WeatherInfoUI
import com.example.weatherapp.base.BaseAdapter
import com.example.weatherapp.base.BaseViewHolder
import kotlin.math.roundToInt

class WeatherInfoHolder(itemView: WeatherInfoItemBinding) : BaseViewHolder(itemView.root) {

    private val binding: WeatherInfoItemBinding = itemView

    override fun setData(data: Any?, position: Int, adapter: BaseAdapter) {
        if (data is WeatherInfoUI) {
            buildUIText(data)
        }
    }

    private fun buildUIText(data: WeatherInfoUI) {
        binding?.tvDate.text =
            String.format(context.getString(R.string.date), data.date)
        binding?.tvAvgTemp.text =
            String.format(context.getString(R.string.average_temperature), data.avgTemperature.roundToInt())
        binding?.tvPressure.text =
            String.format(context.getString(R.string.pressure), data.pressure)
        binding?.tvHumidity.text =
            String.format(context.getString(R.string.humidity), data.humidity)
        binding?.tvDescription.text =
            String.format(context.getString(R.string.description), data.description)
    }
}