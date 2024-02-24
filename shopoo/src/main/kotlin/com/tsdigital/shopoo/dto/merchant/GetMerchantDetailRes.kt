package com.tsdigital.shopoo.dto.merchant

import com.tsdigital.shopoo.entity.Merchant

data class GetMerchantDetailRes(
    val status: Int,
    val message: String,
    val merchant: Merchant
)
