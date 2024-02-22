package com.tsdigital.shopoo.dto.merchant

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateMerchantReq(
    @field:NotBlank
    @field:Size(min = 10, message = "store name should have at least 10 characters")
    var storeName: String,

    @field:NotBlank
    @field:Size(min = 3, message = "firstname should have at least 3 characters")
    var firstName: String,

    @field:NotBlank
    @field:Size(min = 3, message = "lastname should have at least 3 characters")
    var lastName: String,
)
