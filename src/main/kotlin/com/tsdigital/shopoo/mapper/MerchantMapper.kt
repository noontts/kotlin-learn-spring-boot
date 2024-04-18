package com.tsdigital.shopoo.mapper

import com.tsdigital.shopoo.dto.merchant.MerchantListDTO
import com.tsdigital.shopoo.entity.Merchant

class MerchantMapper private constructor(){
    companion object{
        fun toMerchantDto(merchant: Merchant): MerchantListDTO{
            return MerchantListDTO(
                uuid = merchant.uuid,
                firstName = merchant.firstName,
                lastName = merchant.lastName,
                storeName = merchant.storeName,
                phone = merchant.phone,
                createdAt = merchant.createdAt
            )
        }
    }
}