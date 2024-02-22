package com.tsdigital.shopoo.controller.advice

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.dto.error.ErrorRes
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.Date

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(exception: CommonException): ResponseEntity<ErrorRes>{
        return ResponseEntity.badRequest().body(
            ErrorRes(exception.code, exception.message, Date())
        )
    }
}