package com.aungpaing.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpaing.test.R
import com.aungpaing.test.activity.ItemDetailActivity
import com.aungpaing.test.data.vos.ColorVO
import com.aungpaing.test.viewholder.BaseViewHolder
import com.aungpaing.test.viewholder.ColorListViewHolder

class ColorListAdapter(private val context: Context, private val itemDetailActivity: ItemDetailActivity): BaseAdapter<BaseViewHolder<ColorVO>, ColorVO>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ColorVO> {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_color_list, p0, false)
        return ColorListViewHolder(view, itemDetailActivity)
    }
}