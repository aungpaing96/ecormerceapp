package com.aungpaing.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.aungpaing.test.R
import com.aungpaing.test.data.vos.BrandVO
import com.aungpaing.test.fragment.HomeFragment
import com.aungpaing.test.viewholder.BaseViewHolder
import com.aungpaing.test.viewholder.BrandListForHorizontalViewHolder

class BrandListForHorizontalAdapter(private val context: Context, private val homeFragment: HomeFragment): BaseAdapter<BaseViewHolder<BrandVO>, BrandVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BaseViewHolder<BrandVO> {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_brand_list_for_horizontal, parent, false)
        return BrandListForHorizontalViewHolder(view, homeFragment)
    }
}