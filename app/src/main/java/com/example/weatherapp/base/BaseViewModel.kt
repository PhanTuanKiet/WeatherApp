package com.example.weatherapp.base

import android.app.Application
import android.content.res.Resources
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import javax.inject.Inject


open class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    val apiMessageLive: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    private fun updateApiMessage(message : String) {
        apiMessageLive.value = message
    }

   protected fun handleError(e : Throwable) {
       var message = ""
       if(e is HttpException){
            message = e.message()
       }
       updateApiMessage(message)
       e.printStackTrace()
   }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}