package com.tsdigital.shopoo.services

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.constants.ResponseCode
import com.tsdigital.shopoo.dto.merchant.*
import com.tsdigital.shopoo.entity.Merchant
import com.tsdigital.shopoo.mapper.MerchantMapper
import com.tsdigital.shopoo.repository.MerchantRepository
import com.tsdigital.shopoo.utils.MerchantUtils
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.Optional
import java.util.UUID

@Service
class MerchantService(
    private val merchantRepository: MerchantRepository,
    private val merchantUtils: MerchantUtils
) {
    fun addMerchant(createMerchantReq: CreateMerchantReq): CreateMerchantRes {
        try {
            val newMerchant = Merchant(
                firstName = createMerchantReq.firstName,
                lastName = createMerchantReq.lastName,
                storeName = createMerchantReq.storeName,
                phone = createMerchantReq.phone,
                email = createMerchantReq.email
            )
            val merchant = merchantRepository.save(newMerchant)

            val responseCode = ResponseCode.SUCCESS_CREATE

            return CreateMerchantRes(responseCode.code, responseCode.message, merchant)
        } catch (e: Exception) {
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }

    fun getMerchantDetail(uuid: UUID): GetMerchantDetailRes {
        try {
            val merchantOptional: Optional<Merchant> = merchantRepository.findByUuidAndIsDeleteIsFalse(uuid)

            if (merchantOptional.isEmpty) {
                val responseCode = ResponseCode.NOT_FOUND
                throw CommonException(responseCode.code, responseCode.message)
            }

            val merchant: Merchant = merchantOptional.get()
            val responseCode = ResponseCode.SUCCESS
            return GetMerchantDetailRes(responseCode.code, responseCode.message, merchant)

        } catch (e: CommonException) {
            throw e
        } catch (e: Exception) {
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }

    fun retrieveMerchantList(page: Int, size: Int): RetrieveMerchantListRes {
        try {
            val pageable: Pageable = PageRequest.of(page, size)
            val pageResult: Page<Merchant> = merchantRepository.findAllByIsDeleteIsFalse(pageable)

            if (pageResult.isEmpty) {
                val responseCode = ResponseCode.NOT_FOUND
                throw CommonException(responseCode.code, responseCode.message)
            }

            val merchantsDTO = pageResult.map { merchant ->
                MerchantMapper.toMerchantDto(merchant)
            }

            val responseCode = ResponseCode.SUCCESS

            return RetrieveMerchantListRes(
                status = responseCode.code,
                content = merchantsDTO.toList(),
                nextPage = pageResult.hasNext(),
                totalPages = pageResult.totalPages
            )
        } catch (e: CommonException) {
            throw e
        } catch (e: Exception) {
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }

    fun editMerchantDetail(uuid: UUID, editMerchantReq: EditMerchantReq): EditMerchantRes {
        try {
            val merchantOptional: Optional<Merchant> = merchantUtils.merchantOptional(uuid)

            val merchant = merchantOptional.get()

            merchant.apply {
                firstName = editMerchantReq.firstName
                lastName = editMerchantReq.lastName
                phone = editMerchantReq.phone
                email = editMerchantReq.email
                storeName = editMerchantReq.storeName
            }

            merchantRepository.save(merchant)

            val responseCode = ResponseCode.SUCCESS_EDIT

            return EditMerchantRes(responseCode.code, responseCode.message)
        } catch (e: Exception) {
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }

    fun deleteMerchant(uuid: UUID): DeleteMerchantRes {
        try {
            val merchantOptional: Optional<Merchant> = merchantUtils.merchantOptional(uuid)

            val merchant = merchantOptional.get()

            merchant.isDelete = true
            merchantRepository.save(merchant)

            val responseCode = ResponseCode.SUCCESS_DELETE

            return DeleteMerchantRes(responseCode.code, responseCode.message)
        } catch (e: CommonException) {
            throw e
        } catch (e: Exception) {
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }

}