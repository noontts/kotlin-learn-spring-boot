package com.tsdigital.shopoo.dto.error

import java.util.*

data class ErrorValidRes(
    val status: Int,
    val message: List<String>?,
    val timestamp: Date
)
