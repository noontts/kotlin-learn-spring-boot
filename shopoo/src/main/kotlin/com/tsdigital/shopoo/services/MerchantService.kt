package com.tsdigital.shopoo.services

import com.tsdigital.shopoo.dto.merchant.CreateMerchantReq
import com.tsdigital.shopoo.dto.merchant.CreateMerchantRes
import com.tsdigital.shopoo.dto.merchant.RetrieveMerchantListRes
import com.tsdigital.shopoo.entity.Merchant
import com.tsdigital.shopoo.mapper.MerchantListMapper
import com.tsdigital.shopoo.repository.MerchantRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class MerchantService(private val merchantRepository: MerchantRepository) {
    fun addMerchant(createMerchantReq: CreateMerchantReq)
    : CreateMerchantRes{
        val newMerchant = Merchant(
            firstName = createMerchantReq.firstName,
            lastName = createMerchantReq.lastName,
            storeName = createMerchantReq.storeName,
            phone = createMerchantReq.phone,
            email = createMerchantReq.email
        )
        val merchant = merchantRepository.save(newMerchant)

        return CreateMerchantRes(200, "Create Succeed", merchant)
    }
    fun getMerchantDetail(){}
    fun retrieveMerchantList(page: Int, size: Int): RetrieveMerchantListRes {
        val pageable: Pageable = PageRequest.of(page, size)
        val pageResult: Page<Merchant> = merchantRepository.findAllByIsDeleteIsFalse(pageable)

        val merchantsDTO = pageResult.map {merchant ->
            MerchantListMapper.toMerchantDto(merchant)
        }

        return RetrieveMerchantListRes(
            status = 200,
            content = merchantsDTO.toList(),
            nextPage = pageResult.hasNext(),
            totalPages = pageResult.totalPages
        )
    }
    fun editMerchantDetail(){}
    fun deleteMerchantDetail(){}
}