package com.aungpaing.test.data.vos

import java.io.Serializable

class ColorVO(
    val id: Int,
    val color: String,
    var isSelected: Boolean = false
): Serializable {
}