package com.aungpaing.test.data.models

import com.aungpaing.test.network.response.ItemListResponse

interface MyModel {
    fun itemList(
        onSuccess: (ItemListResponse) -> Unit,
        onError: (String) -> Unit
    )
}