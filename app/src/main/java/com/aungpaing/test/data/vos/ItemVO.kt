package com.aungpaing.test.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ItemVO(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("body_html") val bodyHtml: String,
    @SerializedName("product_type") val productType: String,
    @SerializedName("variants") val variantsVOList: MutableList<VariantVO>,
    @SerializedName("images") val imageVOList: MutableList<ImageVO>,
    @SerializedName("image") val imageVO: ImageVO
): Serializable {
}