package com.tsdigital.shopoo.dto.error

import java.util.Date

data class ErrorRes(
    val status: Int,
    val message: String?,
    val timestamp: Date
)
