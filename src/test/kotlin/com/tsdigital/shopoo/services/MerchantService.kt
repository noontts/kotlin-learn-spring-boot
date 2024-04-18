package com.tsdigital.shopoo.services

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.constants.ResponseCode
import com.tsdigital.shopoo.entity.Merchant
import com.tsdigital.shopoo.repository.MerchantRepository
import com.tsdigital.shopoo.utils.MerchantUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*

class MerchantServiceTest {

    private val merchantRepository = mock<MerchantRepository>()
    private val merchantUtils = mock<MerchantUtils>()

    @Test
    fun `test getMerchantDetail when merchant exists`() {
        val uuid = UUID.randomUUID()
        val merchant = Merchant(
            uuid, "Merchant Name", "Test", "TestLastName", "0999999999", "test@gmail.com"
        )

        whenever(merchantRepository.findByUuidAndIsDeleteIsFalse(any())).thenReturn(Optional.of(merchant))

        val merchantService = MerchantService(merchantRepository, merchantUtils)

        val result = merchantService.getMerchantDetail(uuid)

        assertEquals(ResponseCode.SUCCESS.code, result.status)
        assertEquals(ResponseCode.SUCCESS.message, result.message)
        assertEquals(merchant, result.merchant)
    }

    @Test
    fun `test getMerchantDetail when merchant does not exists`() {
        val uuid = UUID.randomUUID()
        val notFoundResponse = ResponseCode.NOT_FOUND

        whenever(merchantRepository.findByUuidAndIsDeleteIsFalse(any())).thenReturn(Optional.empty())

        val merchantService = MerchantService(merchantRepository, merchantUtils)

        val exception = assertThrows(CommonException::class.java) {
            merchantService.getMerchantDetail(uuid)
        }

        assertEquals(notFoundResponse.code, exception.code)
        assertEquals(notFoundResponse.message, exception.message)
    }

    @Test
    fun `test getMerchantDetail when bad request`() {
        val uuid = UUID.randomUUID()
        val badRequestResponse = ResponseCode.BAD_REQUEST

        whenever(merchantRepository.findByUuidAndIsDeleteIsFalse(any())).thenThrow(RuntimeException::class.java)

        val merchantService = MerchantService(merchantRepository, merchantUtils)

        val exception = assertThrows(CommonException::class.java) {
            merchantService.getMerchantDetail(uuid)
        }

        assertEquals(badRequestResponse.code, exception.code)
        assertEquals(badRequestResponse.message, exception.message)
    }
}