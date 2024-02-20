package com.tsdigital.shopoo.repository

import com.tsdigital.shopoo.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface MerchantRepository: JpaRepository<Merchant, UUID>{
}