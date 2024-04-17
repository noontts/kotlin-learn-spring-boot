package com.tsdigital.shopoo.utils

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.constants.ResponseCode
import com.tsdigital.shopoo.entity.Merchant
import com.tsdigital.shopoo.repository.MerchantRepository
import org.springframework.stereotype.Service
import java.util.*
@Service
class MerchantUtils(private val merchantRepository: MerchantRepository) {
    fun merchantOptional(uuid: UUID): Optional<Merchant> {
        val merchantOptional: Optional<Merchant> = merchantRepository.findById(uuid)

        if (merchantOptional.isEmpty) {
            val responseCode = ResponseCode.NOT_FOUND
            throw CommonException(responseCode.code, responseCode.message)
        }
        return merchantOptional
    }
}