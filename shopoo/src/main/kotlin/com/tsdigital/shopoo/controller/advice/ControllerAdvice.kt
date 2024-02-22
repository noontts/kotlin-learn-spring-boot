package com.tsdigital.shopoo.controller.advice

import com.tsdigital.shopoo.config.CommonException
import com.tsdigital.shopoo.dto.error.ErrorRes
import com.tsdigital.shopoo.dto.error.ErrorValidRes
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*


@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(Exception::class)
    fun handleGenericException(e: Exception): ResponseEntity<ErrorRes>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorRes(5000,"Internal Server error", Date()))
    }

    @ExceptionHandler(CommonException::class)
    fun handleCommonException(exception: CommonException): ResponseEntity<ErrorRes>{
        return ResponseEntity.badRequest().body(
            ErrorRes(exception.code, exception.message, Date())
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidException(exception: MethodArgumentNotValidException): ResponseEntity<ErrorValidRes>{

        val fieldErrors: List<FieldError> = exception.fieldErrors

        val errorDetails: MutableList<String> = ArrayList()
        for (fieldError in fieldErrors) {
            errorDetails.add(fieldError.field + ": " + fieldError.defaultMessage)
        }

        return ResponseEntity.badRequest().body(
            ErrorValidRes(500, errorDetails, Date())
        )
    }
}