package com.tsdigital.shopoo.repository

import com.tsdigital.shopoo.dto.merchant.MerchantListDTO
import com.tsdigital.shopoo.entity.Merchant
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.UUID

interface MerchantRepository: JpaRepository<Merchant, UUID>{
    fun findAllByIsDeleteIsFalse(pageable: Pageable): Page<Merchant>
}