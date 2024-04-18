package com.tsdigital.shopoo.dto.merchant

data class RetrieveMerchantListRes(
    val status: Int,
    val content: List<MerchantListDTO>,
    val nextPage: Boolean,
    val totalPages: Int,
)
