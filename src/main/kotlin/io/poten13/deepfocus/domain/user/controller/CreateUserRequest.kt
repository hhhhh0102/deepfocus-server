package io.poten13.deepfocus.domain.user.controller

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 생성 요청")
data class CreateUserRequest(
    @field:Schema(description = "디바이스 토큰", required = true, example = "device123token")
    val deviceToken: String
)