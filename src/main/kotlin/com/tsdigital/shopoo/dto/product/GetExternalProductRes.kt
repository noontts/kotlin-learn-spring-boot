package com.tsdigital.shopoo.dto.product

import com.fasterxml.jackson.annotation.JsonProperty

data class GetExternalProductRes(
    @JsonProperty("external_products")
    val externalProduct: List<ExternalProduct>
)
