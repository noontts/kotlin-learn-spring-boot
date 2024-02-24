package com.tsdigital.shopoo.repository


import com.tsdigital.shopoo.entity.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProductRepository: JpaRepository<Product, UUID> {
    fun findAllByMerchantUuidAndIsDeleteIsFalse(merchantUUID: UUID, pageable: Pageable): Page<Product>
}