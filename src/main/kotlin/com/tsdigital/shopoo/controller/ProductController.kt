package com.tsdigital.shopoo.controller

import com.tsdigital.shopoo.dto.product.*
import com.tsdigital.shopoo.services.ProductService
import jakarta.validation.Valid
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import java.util.UUID

@RestController
@RequestMapping("/api/v1/shopoo")
class ProductController(private val productService: ProductService) {

    @PostMapping("/products")
    fun getProductPagination(): GetProductPaginateRes {
        return GetProductPaginateRes("Hello")
    }

    @PostMapping("/products/merchant")
    fun getProductByMerchant(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "15") size: Int,
        @Valid @RequestBody getProductByMerchantReq: GetProductByMerchantReq
    )
            : GetProductByMerchantRes {
        return productService.getProductByMerchantUUID(getProductByMerchantReq.uuid, page, size)
    }

    @PostMapping("/product/{id}")
    fun getProductDetail(@PathVariable id: UUID): GetProductDetailRes {
        return GetProductDetailRes("Hello $id")
    }

    @GetMapping("/rest-template")
    fun getExternalProduct(@RequestParam offset: Int = 0, @RequestParam limit: Int = 20): GetExternalProductRes {
        val restTemplate = RestTemplate()

        val externalProductURL = "https://api.escuelajs.co/api/v1/products?offset=$offset&limit=$limit"

        val response = restTemplate.getForObject(externalProductURL, Array<ExternalProduct>::class.java)!!.toList()

        return GetExternalProductRes(response)
    }
}