package io.poten13.deepfocus.domain.user.controller

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 생성 응답")
data class CreateUserResponse(
    @field:Schema(description = "사용자 토큰", example = "abc123def456ghi789jkl", required = true)
    val userToken: String
)