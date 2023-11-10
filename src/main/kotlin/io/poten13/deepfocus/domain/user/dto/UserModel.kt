package io.poten13.deepfocus.domain.user.dto

import io.poten13.deepfocus.domain.user.entity.User
import io.poten13.deepfocus.global.constants.RoleType
import io.poten13.deepfocus.global.constants.Severity

data class UserModel(
    val userId: Long,
    val userToken: String,
    val nickname: String,
    val roleType: RoleType,
    val severity: Severity?
) {
    companion object {
        fun from(user: User): UserModel {
            return UserModel(
                userId = user.userId!!,
                userToken = user.userToken,
                nickname = user.nickname,
                roleType = user.roleType,
                severity =  user.severity
            )
        }
    }
}