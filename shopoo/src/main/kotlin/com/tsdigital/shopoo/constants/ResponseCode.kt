package com.tsdigital.shopoo.constants

enum class ResponseCode(val code: Int, val message: String) {
    SUCCESS(2000,"Succeed."),
    SUCCESS_CREATE(2001,"Create Succeed."),
    SUCCESS_DELETE(2000,"Delete Succeed."),
    SUCCESS_EDIT(2000, "Edit Succeed"),

    BAD_REQUEST(4000, "Bad Request."),
    FAIL_VALIDATE(4000, "Validate request fail."),
    NOT_FOUND(4004, "Not found"),

    INTERNAL_SERVER_ERROR(5000, "Internal Server Error")
}