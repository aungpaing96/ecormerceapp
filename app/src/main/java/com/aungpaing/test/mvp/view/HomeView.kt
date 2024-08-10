package com.aungpaing.test.mvp.view

import com.aungpaing.test.network.response.ItemListResponse

interface HomeView: BaseView {
    fun itemListResponse(response: ItemListResponse)
}