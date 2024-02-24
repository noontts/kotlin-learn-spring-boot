package com.tsdigital.shopoo.dto.merchant

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class GetMerchantDetailReq(
    @field:NotNull(message = "uuid should not null")
    val uuid: UUID,
)
