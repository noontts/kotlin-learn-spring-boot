package com.tsdigital.shopoo.services

import com.tsdigital.shopoo.dto.merchant.CreateMerchantReq
import com.tsdigital.shopoo.dto.merchant.CreateMerchantRes
import com.tsdigital.shopoo.entity.Merchant
import com.tsdigital.shopoo.repository.MerchantRepository
import org.springframework.stereotype.Service

@Service
class MerchantService(private val merchantRepository: MerchantRepository) {
    fun addMerchant(createMerchantReq: CreateMerchantReq)
    : CreateMerchantRes{
        val newMerchant = Merchant(
            firstName = createMerchantReq.firstName,
            lastName = createMerchantReq.lastName,
            storeName = createMerchantReq.storeName
        )

        val merchant = merchantRepository.save(newMerchant)

        return CreateMerchantRes(200, "Create Succeed", merchant)
    }
}