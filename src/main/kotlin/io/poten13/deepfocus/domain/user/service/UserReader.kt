package io.poten13.deepfocus.domain.user.service

import io.poten13.deepfocus.domain.user.dto.UserModel
import io.poten13.deepfocus.domain.user.repository.DeviceRepository
import io.poten13.deepfocus.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserReader(
    private val userRepository: UserRepository,
    private val deviceRepository: DeviceRepository
) {

    fun readByDeviceToken(deviceToken: String): UserModel? {
        return deviceRepository.findByDeviceToken(deviceToken)
            ?.userId
            ?.let { userId -> userRepository.findById(userId).get() }
            ?.let { UserModel.from(it) }
    }

    fun readByUserToken(userToken: String): UserModel? {
        return userRepository.findByUserToken(userToken)?.let { UserModel.from(it) }
    }
}