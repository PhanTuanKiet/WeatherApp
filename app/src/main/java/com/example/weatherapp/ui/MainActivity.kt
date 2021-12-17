package com.example.weatherapp.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.WeatherInfoUI
import com.example.weatherapp.ui.adapter.WeatherInfoAdapter
import com.example.weatherapp.viewmodel.WeatherInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val weatherViewModel: WeatherInfoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val weatherAdapter: WeatherInfoAdapter by lazy {
        WeatherInfoAdapter()
    }

    private val textWatcherInput by lazy {
        object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.let {
                    weatherViewModel.validateCityName(it.trim())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        binding?.rvWeatherInfoList?.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            setRecycledViewPool(RecyclerView.RecycledViewPool())
        }

        buildUI()
    }

    private fun buildUI() {
        binding?.rvWeatherInfoList?.adapter = weatherAdapter
        buildUIObserver()
        buildWeatherButton()
        addListenerEditTextCityName()
    }

    private fun buildWeatherButton() {
        binding?.btnGetWeather.setOnClickListener {
            val cityName = binding?.edtSearchBox.text.toString()
            weatherViewModel.getWeatherInfo(cityName)
        }
    }

    private fun buildUIObserver() {
        weatherViewModel.weatherResultData.observe(
            this,
            observerData
        )

        weatherViewModel.isEnableBtnGetWeather.observe(
            this,
            observerTextValidate
        )

        weatherViewModel.inputValidateMessageLive.observe(
            this,
            observerTextError
        )

        weatherViewModel.apiMessageLive.observe(
            this,
            observerApiMessage
        )
    }


    private val observerData: Observer<List<WeatherInfoUI>?> by lazy {
        Observer<List<WeatherInfoUI>?> { list ->
            weatherAdapter.listData = list as MutableList<Any>?
            weatherAdapter.notifyDataSetChanged()
        }
    }

    private val observerTextValidate: Observer<Boolean> by lazy {
        Observer<Boolean> { isEnable ->
            binding?.btnGetWeather.isEnabled = isEnable
        }
    }

    private val observerApiMessage: Observer<String> by lazy {
        Observer<String> { message ->
            showErrorAlert(message)
        }
    }

    private val observerTextError: Observer<Int> by lazy {
        Observer<Int> { messageId ->
            binding?.tvError.text = resources.getString(messageId)
        }
    }


    private fun addListenerEditTextCityName() {
        binding?.edtSearchBox?.addTextChangedListener(textWatcherInput)
    }

    private fun showErrorAlert(message: String) {
        val builder = AlertDialog.Builder(this)

        val buttonClick = { dialog: DialogInterface, which: Int ->
            dialog.dismiss()
        }

        builder.setTitle("Error").setMessage(message).setPositiveButton("OK", buttonClick).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        weatherViewModel.weatherResultData.removeObserver(observerData)
        weatherViewModel.isEnableBtnGetWeather.removeObserver(observerTextValidate)
        weatherViewModel.inputValidateMessageLive.removeObserver(observerTextError)
        weatherViewModel.apiMessageLive.removeObserver(observerApiMessage)
    }


}