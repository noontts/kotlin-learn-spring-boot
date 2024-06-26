package com.tsdigital.shopoo.controller

import com.tsdigital.shopoo.dto.merchant.*
import com.tsdigital.shopoo.services.MerchantService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("api/v1/merchants")
class MerchantController(private val merchantService: MerchantService) {
    @PostMapping("/create")
    fun createMerchant(@Valid @RequestBody createMerchantReq: CreateMerchantReq): CreateMerchantRes {
        return merchantService.addMerchant(createMerchantReq)
    }

    @PostMapping("/list")
    fun retrieveMerchantList(
        @RequestParam(defaultValue = "0") offset: Int,
        @RequestParam(defaultValue = "15") limit: Int
    ): RetrieveMerchantListRes {
        return merchantService.retrieveMerchantList(offset, limit)
    }

    @PostMapping("/detail")
    fun getMerchantDetail(@Valid @RequestBody getMerchantDetailReq: GetMerchantDetailReq)
            : GetMerchantDetailRes {
        return merchantService.getMerchantDetail(getMerchantDetailReq.uuid)
    }

    @PostMapping("/edit")
    fun editMerchantDetail(
        @Valid @RequestBody editMerchantReq: EditMerchantReq,
        @RequestParam uuid: UUID
    ): EditMerchantRes {
        return merchantService.editMerchantDetail(uuid, editMerchantReq)
    }

    @PostMapping("/delete")
    fun deleteMerchantDetail(@Valid @RequestBody deleteMerchantReq: DeleteMerchantReq)
            : DeleteMerchantRes {
        return merchantService.deleteMerchant(deleteMerchantReq.uuid)
    }
}