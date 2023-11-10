package io.poten13.deepfocus.domain.user.controller

import io.poten13.deepfocus.domain.user.service.UserService
import io.poten13.deepfocus.global.constants.Severity
import io.poten13.deepfocus.global.dto.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @Operation(summary = "로그인", description = "device token 으로 로그인 (deviceToken 으로 조회 되는 사용자가 없는 경우 강제 회원가입 처리)")
    @PostMapping("/login")
    fun login(request: LoginRequest): ApiResponse<LoginResponse> {
        var isNew = false
        val user = userService.readBy(request.deviceToken) ?: let {
            isNew = true
            userService.save(request.deviceToken)
        }
        val response = LoginResponse(user.userToken, isNew)
        return ApiResponse.ok(response)
    }

    @Operation(summary = "사용자 조회")
    @GetMapping
    fun getUser(): ApiResponse<UserResponse> {
        val userToken = SecurityContextHolder.getContext().authentication.name
        val user = userService.get(userToken)
        return ApiResponse.ok(UserResponse.from(user))
    }

    @Operation(summary = "사용자 심각도 수정(저장)")
    @PatchMapping
    fun updateUserSeverity(@RequestParam severityParam: String): ApiResponse<String> {
        val userToken = SecurityContextHolder.getContext().authentication.name
        val severity = try {
            Severity.valueOf(severityParam.uppercase()) // 파라미터를 대문자로 변환하여 Enum으로 파싱
        } catch (e: IllegalArgumentException) {
            // todo : BusinessException 적용
            throw RuntimeException("Invalid severity: $severityParam")
        }
        userService.updateUserSeverity(userToken, severity);
        return ApiResponse.success()
    }
}