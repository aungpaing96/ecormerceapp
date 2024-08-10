package com.aungpaing.test.data.vos

import java.io.Serializable

class SizeVO(
    val id: Int,
    val size: String,
    var isSelected: Boolean = false
): Serializable {
}