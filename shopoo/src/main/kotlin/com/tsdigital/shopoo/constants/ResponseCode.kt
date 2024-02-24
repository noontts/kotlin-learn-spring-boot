package com.tsdigital.shopoo.constants

enum class ResponseCode(val code: Int, val message: String) {
    SUCCESS_CREATE(2000,"Create Succeed."),
    SUCCESS_GET(2001,"Succeed."),

    BAD_REQUEST(4000, "Bad Request."),
    FAIL_VALIDATE(4000, "Validate request fail."),
    NOT_FOUND(4004, "Not found"),

    INTERNAL_SERVER_ERROR(5000, "Internal Server Error")
}