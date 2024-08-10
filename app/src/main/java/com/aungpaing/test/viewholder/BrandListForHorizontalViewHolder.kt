package com.aungpaing.test.viewholder

import android.view.View
import com.aungpaing.test.data.vos.BrandVO
import com.aungpaing.test.fragment.HomeFragment
import com.aungpaing.test.utils.BRAND_LIST_SIZE
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_brand_list_for_horizontal.view.iv_brand
import kotlinx.android.synthetic.main.adapter_brand_list_for_horizontal.view.view_fake
import kotlinx.android.synthetic.main.adapter_item_list.view.iv_love

class BrandListForHorizontalViewHolder(private val view: View, private val mDelegate: HomeFragment): BaseViewHolder<BrandVO>(view) {

    private lateinit var vo: BrandVO

    init {

    }

    override fun bindData(data: BrandVO) {
        vo = data
        Glide.with(itemView.context)
            .load(data.imgLink)
            .into(view.iv_brand)
        view.view_fake.visibility = if (adapterPosition == (BRAND_LIST_SIZE - 1)) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}