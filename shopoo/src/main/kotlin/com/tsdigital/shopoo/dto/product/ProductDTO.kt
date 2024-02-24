package com.tsdigital.shopoo.dto.product

import java.util.*

data class ProductDTO(
    val uuid: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val inStock: Int,
    val createdAt: Date,
    val updatedAt: Date
)
