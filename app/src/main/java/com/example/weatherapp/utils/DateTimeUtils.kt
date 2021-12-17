package com.example.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

class DateTimeUtils {

     companion object {

          fun convertMillisecondToDate(second : Long) : String {
               val formatter =  SimpleDateFormat("EEE, dd MMM yyyy", Locale.US);
               return formatter.format(Date(second * 1000))
          }

     }
}