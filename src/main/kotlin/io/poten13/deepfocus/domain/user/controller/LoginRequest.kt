package io.poten13.deepfocus.domain.user.controller

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "로그인 요청")
class LoginRequest(
    @field:Schema(description = "디바이스 토큰", required = true, example = "device123token")
    val deviceToken: String
)