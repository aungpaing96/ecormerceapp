package com.aungpaing.test.delegate

import com.aungpaing.test.data.vos.ColorVO
import com.aungpaing.test.data.vos.SizeVO

interface ItemDetailDelegate {
    fun onTapSize(position: Int, vo: SizeVO)
    fun onTapColor(position: Int, vo: ColorVO)
}