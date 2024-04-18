package com.tsdigital.shopoo.dto.merchant

import com.tsdigital.shopoo.entity.Merchant

data class CreateMerchantRes(
    val status: Int,
    val message: String,
    val merchant: Merchant
)
