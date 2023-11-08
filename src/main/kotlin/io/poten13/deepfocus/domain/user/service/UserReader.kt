package io.poten13.deepfocus.domain.user.service

import io.poten13.deepfocus.domain.user.dto.UserModel
import io.poten13.deepfocus.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserReader(private val userRepository: UserRepository) {

    fun readBy(userToken: String): UserModel? {
        return userRepository.findByUserToken(userToken)?.let { UserModel.from(it) }
    }
}