package io.poten13.deepfocus.global.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiResponse<T>(
    val status: Int,
    val message: String,
    val data: T?
) {
    companion object {
        fun <T> ok(data: T): ApiResponse<T> {
            return ApiResponse(
                status = 200,
                message = "SUCCESS",
                data = data
            )
        }

        fun <T> success(data: T? = null): ApiResponse<T> {
            return ApiResponse(
                status = 200,
                message = "SUCCESS",
                data = data
            )
        }
    }
}