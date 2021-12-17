package com.example.weatherapp.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    var listData : MutableList<Any>? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if(position != RecyclerView.NO_POSITION){
            if (listData != null && listData!!.size > position) {
                holder.setData(listData!![position], position, this)
            } else {
                holder.setData(null, position, this)
            }
        }
    }

    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }
}