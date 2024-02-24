package com.tsdigital.shopoo.dto.product


import jakarta.validation.constraints.NotNull
import java.util.UUID

data class GetProductByMerchantReq(
    @field:NotNull(message = "uuid should not null")
    val uuid: UUID,
)
