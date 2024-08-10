package com.aungpaing.test.network.response

import com.aungpaing.test.data.vos.ItemVO
import com.google.gson.annotations.SerializedName

class ItemListResponse(
    @SerializedName("products") val itemVOList: MutableList<ItemVO>
) {
}