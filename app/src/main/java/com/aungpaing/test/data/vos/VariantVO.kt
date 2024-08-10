package com.aungpaing.test.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class VariantVO(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: String,
    @SerializedName("image_id") val imageId: Long
): Serializable {
}