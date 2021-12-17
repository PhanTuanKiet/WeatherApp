package com.example.weatherapp.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var context: Context = itemView.context

    abstract fun setData(data: Any?, position: Int, adapter: BaseAdapter)

}