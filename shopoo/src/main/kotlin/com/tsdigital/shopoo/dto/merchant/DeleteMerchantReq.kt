package com.tsdigital.shopoo.dto.merchant

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class DeleteMerchantReq(
    @field:NotNull(message = "uuid should not null")
    val uuid: UUID
)
