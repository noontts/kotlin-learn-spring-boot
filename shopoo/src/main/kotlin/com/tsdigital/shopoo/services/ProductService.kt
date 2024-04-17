package com.tsdigital.shopoo.services

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.constants.ResponseCode
import com.tsdigital.shopoo.dto.product.GetProductByMerchantRes
import com.tsdigital.shopoo.entity.Product
import com.tsdigital.shopoo.mapper.ProductMapper
import com.tsdigital.shopoo.repository.ProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun getProductByMerchantUUID(uuid: UUID, page: Int, size: Int): GetProductByMerchantRes {
        try {
            val pageable: Pageable = PageRequest.of(page, size)
            val pageResult: Page<Product> = productRepository.findAllByMerchantUuidAndIsDeleteIsFalse(uuid, pageable)

            if (pageResult.isEmpty) {
                val responseCode = ResponseCode.NOT_FOUND
                throw CommonException(responseCode.code, responseCode.message)
            }

            val productDTO = pageResult.map { product ->
                ProductMapper.toProductDto(product)
            }

            val responseCode = ResponseCode.SUCCESS

            return GetProductByMerchantRes(
                responseCode.code,
                responseCode.message,
                productDTO.toList()
            )
        } catch (e: CommonException) {
            throw e
        } catch (e: Exception) {
            println(e.message)
            val responseCode = ResponseCode.BAD_REQUEST
            throw CommonException(responseCode.code, responseCode.message)
        }
    }
}