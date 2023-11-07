package io.poten13.deepfocus.global.dto

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