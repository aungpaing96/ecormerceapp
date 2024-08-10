package com.aungpaing.test.network

import com.aungpaing.test.network.response.ItemListResponse
import com.aungpaing.test.utils.ITEM_LIST_URL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface NetworkApi {

    @GET(ITEM_LIST_URL)
    fun itemList(
        @Header("X-Shopify-Access-Token") token: String
    ): Call<ItemListResponse>
}
