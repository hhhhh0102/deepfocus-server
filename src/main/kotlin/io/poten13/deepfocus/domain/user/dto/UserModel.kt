package io.poten13.deepfocus.domain.user.dto

import io.poten13.deepfocus.domain.user.entity.User

data class UserModel(
    val userId: Long,
    val userToken: String,
    val nickname: String
) {
    companion object {
        fun from(user: User): UserModel {
            return UserModel(
                userId = user.userId!!,
                userToken = user.userToken,
                nickname = user.nickname
            )
        }
    }
}