package com.tsdigital.shopoo.dto.merchant

import java.util.Date
import java.util.UUID

data class MerchantListDTO(
    val uuid: UUID?,
    val storeName: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val createdAt: Date?,
)
