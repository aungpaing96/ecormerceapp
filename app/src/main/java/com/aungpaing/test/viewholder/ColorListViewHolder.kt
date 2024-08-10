package com.aungpaing.test.viewholder

import android.view.View
import com.aungpaing.test.R
import com.aungpaing.test.activity.ItemDetailActivity
import com.aungpaing.test.data.vos.ColorVO
import kotlinx.android.synthetic.main.adapter_color_list.view.cl_color
import kotlinx.android.synthetic.main.adapter_color_list.view.iv_selected

class ColorListViewHolder(private val view: View, private val mDelegate: ItemDetailActivity): BaseViewHolder<ColorVO>(view) {

    private lateinit var vo: ColorVO

    init {
        itemView.setOnClickListener {
            mDelegate.onTapColor(adapterPosition, vo)
        }
    }

    override fun bindData(data: ColorVO) {
        vo = data
        view.iv_selected.visibility = if (data.isSelected) {
            View.VISIBLE
        } else {
            View.GONE
        }
        when (data.color) {
            "white" -> view.cl_color.setBackgroundResource(R.drawable.cl_color_white_bg)
            "black" -> view.cl_color.setBackgroundResource(R.drawable.cl_color_black_bg)
            "green" -> view.cl_color.setBackgroundResource(R.drawable.cl_color_green_bg)
            "blue" -> view.cl_color.setBackgroundResource(R.drawable.cl_color_blue_bg)
        }
    }
}