package com.tsdigital.shopoo.mapper

import com.tsdigital.shopoo.dto.product.ProductDTO
import com.tsdigital.shopoo.entity.Product

class ProductListMapper private constructor() {
    companion object{
        fun toProductDto(product: Product): ProductDTO {
            return ProductDTO(
                uuid = product.uuid,
                name = product.name,
                description = product.description,
                price = product.price,
                inStock = product.inStock,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
            )
        }
    }
}