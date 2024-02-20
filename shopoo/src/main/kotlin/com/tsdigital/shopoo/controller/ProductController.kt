package com.tsdigital.shopoo.controller

import com.tsdigital.shopoo.dto.product.GetProductDetailRes
import com.tsdigital.shopoo.dto.product.GetProductPaginateRes
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/shopoo")
class ProductController {

    @PostMapping("/products")
    fun getProductPagination():GetProductPaginateRes{
        return GetProductPaginateRes("Hello")
    }

    @PostMapping("/product/{id}")
    fun getProductDetail(@PathVariable id: UUID):GetProductDetailRes{
        return GetProductDetailRes("Hello $id")
    }
}