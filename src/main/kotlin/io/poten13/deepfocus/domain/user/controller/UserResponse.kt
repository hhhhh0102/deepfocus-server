package io.poten13.deepfocus.domain.user.controller

import io.poten13.deepfocus.domain.user.dto.UserModel
import io.poten13.deepfocus.global.constants.Severity

data class UserResponse(
    val nickname: String,
    val severity: Severity?
) {
    companion object {
        fun from(userModel: UserModel): UserResponse {
            return UserResponse(userModel.nickname, userModel.severity)
        }
    }
}