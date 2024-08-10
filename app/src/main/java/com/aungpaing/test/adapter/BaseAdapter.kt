package com.aungpaing.test.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.aungpaing.test.viewholder.BaseViewHolder

abstract class BaseAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    private var mDataList: MutableList<W> = mutableListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        //holder.bindData(mDataList[position])
        holder.bindData(mDataList[position])
    }

    override fun getItemCount(): Int {
        if (mDataList != null) {
            return mDataList.size
        }
        return 0
    }

    fun setData(data: MutableList<W>){
        Log.d("test_data", "data size = ${data.size} ${data}")
        //mDataList.clear()
        mDataList = data
        //mDataList.addAll(data)
        notifyDataSetChanged()
    }

    fun setData(data: MutableList<W>, position: Int){
        Log.d("test_data", "data size = ${data.size} ${data}")
        //mDataList.clear()
        mDataList = data
        //mDataList.addAll(data)
        notifyItemChanged(position)
    }
}