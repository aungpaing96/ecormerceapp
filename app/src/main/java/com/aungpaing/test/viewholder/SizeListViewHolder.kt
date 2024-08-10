package com.aungpaing.test.viewholder

import android.view.View
import com.aungpaing.test.R
import com.aungpaing.test.activity.ItemDetailActivity
import com.aungpaing.test.data.vos.SizeVO
import com.aungpaing.test.utils.SIZE_LIST_SIZE
import kotlinx.android.synthetic.main.adapter_size_list.view.tv_size
import kotlinx.android.synthetic.main.adapter_size_list.view.view_fake

class SizeListViewHolder(private val view: View, private val mDelegate: ItemDetailActivity): BaseViewHolder<SizeVO>(view) {

    private lateinit var vo: SizeVO

    init {
        itemView.setOnClickListener {
            mDelegate.onTapSize(adapterPosition, vo)
        }
    }

    override fun bindData(data: SizeVO) {
        vo = data
        view.tv_size.text = data.size
        if (data.isSelected) {
            view.tv_size.setTextColor(itemView.context.resources.getColor(R.color.white))
            view.tv_size.setBackgroundResource(R.drawable.tv_size_bg_selected)
        } else {
            view.tv_size.setTextColor(itemView.context.resources.getColor(R.color.black))
            view.tv_size.setBackgroundResource(R.drawable.tv_size_bg_unselected)
        }
        view.view_fake.visibility = if (adapterPosition == (SIZE_LIST_SIZE - 1)) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}