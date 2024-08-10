package com.aungpaing.test.data.models

import com.aungpaing.test.network.response.ItemListResponse
import com.aungpaing.test.utils.AUTHORIZATION
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MyModelImpl: BaseModel(), MyModel {
    override fun itemList(onSuccess: (ItemListResponse) -> Unit, onError: (String) -> Unit) {
        val listResponse = mNetworkApi.itemList(AUTHORIZATION)
        listResponse.enqueue(object : Callback<ItemListResponse> {
            override fun onResponse(p0: Call<ItemListResponse>, response: Response<ItemListResponse>) {
                if (response.isSuccessful) {
                    val mResponse = response.body()
                    if (mResponse != null) {
                        onSuccess(mResponse)
                    } else {
                        onError(response.message())
                    }
                } else {
                    onError(response.message())
                }
            }

            override fun onFailure(p0: Call<ItemListResponse>, p1: Throwable) {
                onError(p1.message.toString())
            }

        })
    }

}