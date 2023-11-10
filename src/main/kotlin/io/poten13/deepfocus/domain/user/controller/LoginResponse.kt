package io.poten13.deepfocus.domain.user.controller

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "로그인 응답")
class LoginResponse(
    @field:Schema(description = "사용자 토큰", example = "abc123def456ghi789jkl", required = true)
    val userToken: String,
    @field:Schema(description = "최초 회원 가입 여부", example = "true", required = true)
    val isNew: Boolean
)