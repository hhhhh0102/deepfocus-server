package io.poten13.deepfocus.domain.user.service

import io.poten13.deepfocus.domain.user.dto.DeviceModel
import io.poten13.deepfocus.domain.user.dto.UserModel
import io.poten13.deepfocus.domain.user.entity.Device
import io.poten13.deepfocus.domain.user.entity.User
import io.poten13.deepfocus.domain.user.repository.DeviceRepository
import io.poten13.deepfocus.domain.user.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserCommander(
    private val userRepository: UserRepository,
    private val deviceRepository: DeviceRepository) {
    fun saveUser(command: CreateUserCommand): UserModel = UserModel.from(userRepository.save(User.from(command)))

    fun saveDevice(command: CreateDeviceCommand): DeviceModel = DeviceModel.from(deviceRepository.save(Device.from(command)))

    @Transactional
    fun updateSeverity(command: UpdateSeverityCommand) {
        val user = userRepository.findByUserToken(command.userToken) ?: throw RuntimeException("User not found")
        user.severity = command.severity
    }
}