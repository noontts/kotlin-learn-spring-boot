package com.tsdigital.shopoo.dto.product

data class ExternalProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val images: List<String>,
    val creationAt: String,
    val updatedAt: String,
)
