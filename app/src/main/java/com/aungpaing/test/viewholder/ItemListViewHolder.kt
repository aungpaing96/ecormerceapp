package com.aungpaing.test.viewholder

import android.annotation.SuppressLint
import android.view.View
import com.aungpaing.test.R
import com.aungpaing.test.data.vos.ItemVO
import com.aungpaing.test.fragment.HomeFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_item_list.view.iv_cart
import kotlinx.android.synthetic.main.adapter_item_list.view.iv_item
import kotlinx.android.synthetic.main.adapter_item_list.view.iv_love
import kotlinx.android.synthetic.main.adapter_item_list.view.tv_name
import kotlinx.android.synthetic.main.adapter_item_list.view.tv_price

class ItemListViewHolder(private val view: View, private val mDelegate: HomeFragment): BaseViewHolder<ItemVO>(view) {

    private lateinit var vo: ItemVO

    init {
        itemView.setOnClickListener {
            mDelegate.onTapItem(adapterPosition, vo)
        }

        view.iv_love.setOnClickListener {
            mDelegate.onTapLove(adapterPosition, vo)
        }

        view.iv_cart.setOnClickListener {
            mDelegate.onTapCart(adapterPosition, vo)
        }
    }


    @SuppressLint("SetTextI18n")
    override fun bindData(data: ItemVO) {
        vo = data
        view.tv_price.text = "$${data.variantsVOList[0].price}"
        val imgLink = if (data.imageVO != null) {
            data.imageVO.src
        } else {
            R.drawable.ic_placeholder
        }
        Glide.with(itemView.context)
            .load(imgLink)
            .into(view.iv_item)
        view.tv_name.text = data.title
    }
}