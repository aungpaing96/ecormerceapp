package com.aungpaing.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpaing.test.R
import com.aungpaing.test.activity.ItemDetailActivity
import com.aungpaing.test.data.vos.SizeVO
import com.aungpaing.test.viewholder.BaseViewHolder
import com.aungpaing.test.viewholder.SizeListViewHolder

class SizeListAdapter(private val context: Context, private val itemDetailActivity: ItemDetailActivity): BaseAdapter<BaseViewHolder<SizeVO>, SizeVO>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<SizeVO> {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_size_list, p0, false)
        return SizeListViewHolder(view, itemDetailActivity)
    }
}