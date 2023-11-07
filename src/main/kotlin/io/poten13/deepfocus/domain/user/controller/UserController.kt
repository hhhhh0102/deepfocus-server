package io.poten13.deepfocus.domain.user.controller

import io.poten13.deepfocus.domain.user.service.UserService
import io.poten13.deepfocus.global.dto.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User", description = "사용자 관리 API")
@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {

    @Operation(summary = "사용자 추가", description = "device token 으로 사용자를 추가합니다")
    @PostMapping
    fun createUser(request: CreateUserRequest): ApiResponse<CreateUserResponse> {
        val user = userService.save(request.deviceToken)
        return ApiResponse.ok(CreateUserResponse(user.userToken))
    }
}