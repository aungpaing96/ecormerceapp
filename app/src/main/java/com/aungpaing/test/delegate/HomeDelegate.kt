package com.aungpaing.test.delegate

import com.aungpaing.test.data.vos.ItemVO

interface HomeDelegate {
    fun onTapLove(position: Int, vo: ItemVO)
    fun onTapCart(position: Int, vo: ItemVO)
    fun onTapItem(position: Int, vo: ItemVO)
}