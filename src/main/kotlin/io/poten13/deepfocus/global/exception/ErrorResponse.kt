//package io.poten13.deepfocus.global.exception
//
//import io.poten13.deepfocus.global.constants.ErrorCode
//import org.springframework.http.HttpStatus
//
//class ErrorResponse {
//    val status: HttpStatus
//    val message: String
//    val errorCode: String
//
//    private constructor(code: ErrorCode) {
//        status = code.httpStatus
//        message = code.message
//        errorCode = code.errorCode
//    }
//}