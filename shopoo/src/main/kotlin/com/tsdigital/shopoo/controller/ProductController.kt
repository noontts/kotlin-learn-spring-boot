package com.tsdigital.shopoo.controller

import com.tsdigital.shopoo.dto.product.GetProductByMerchantReq
import com.tsdigital.shopoo.dto.product.GetProductByMerchantRes
import com.tsdigital.shopoo.dto.product.GetProductDetailRes
import com.tsdigital.shopoo.dto.product.GetProductPaginateRes
import com.tsdigital.shopoo.services.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/shopoo")
class ProductController(private val productService: ProductService) {

    @PostMapping("/products")
    fun getProductPagination():GetProductPaginateRes{
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
    fun getProductDetail(@PathVariable id: UUID):GetProductDetailRes{
        return GetProductDetailRes("Hello $id")
    }
}