package com.aungpaing.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpaing.test.R
import com.aungpaing.test.data.vos.ItemVO
import com.aungpaing.test.fragment.HomeFragment
import com.aungpaing.test.viewholder.BaseViewHolder
import com.aungpaing.test.viewholder.ItemListViewHolder

class ItemListAdapter(private val context: Context, private val homeFragment: HomeFragment): BaseAdapter<BaseViewHolder<ItemVO>, ItemVO>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BaseViewHolder<ItemVO> {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_item_list, p0, false)
        return ItemListViewHolder(view, homeFragment)
    }
}