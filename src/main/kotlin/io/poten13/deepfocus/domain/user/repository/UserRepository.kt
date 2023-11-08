package io.poten13.deepfocus.domain.user.repository

import io.poten13.deepfocus.domain.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByUserToken(userToken: String): User?
}