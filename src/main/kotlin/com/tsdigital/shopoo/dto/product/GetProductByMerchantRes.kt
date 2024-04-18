package com.tsdigital.shopoo.dto.product


data class GetProductByMerchantRes(
    val status: Int,
    val message: String,
    val product: List<ProductDTO>
)
