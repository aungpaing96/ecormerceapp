package com.aungpaing.test.data.vos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ImageVO(
    @SerializedName("id") val id: Long,
    @SerializedName("src") val src: String
): Serializable {
}