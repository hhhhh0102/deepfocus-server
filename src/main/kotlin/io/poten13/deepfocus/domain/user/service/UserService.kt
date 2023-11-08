package io.poten13.deepfocus.domain.user.service

import io.poten13.deepfocus.domain.user.client.NicknameGeneratorClient
import io.poten13.deepfocus.domain.user.dto.UserModel
import io.poten13.deepfocus.global.constants.Constants.MAX_NICKNAME_LENGTH
import io.poten13.deepfocus.global.constants.Constants.REQUIRED_NICKNAME_COUNT
import io.poten13.deepfocus.global.constants.Constants.NICKNAME_RESPONSE_FORMAT
import io.poten13.deepfocus.global.constants.Severity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    val commander: UserCommander,
    val reader: UserReader,
    val nicknameGeneratorClient: NicknameGeneratorClient
    ) {
    fun save(deviceToken: String): UserModel {
        // todo : duplicate check
        val nickname = nicknameGeneratorClient.generateNickname(
            NICKNAME_RESPONSE_FORMAT, REQUIRED_NICKNAME_COUNT, MAX_NICKNAME_LENGTH)
        val user = commander.saveUser(CreateUserCommand(nickname, UUID.randomUUID().toString()))
        commander.saveDevice(CreateDeviceCommand(deviceToken, user.userId))
        return user
    }

    fun get(userToken: String): UserModel {
        // todo : BusinessException 으로 정의
        return reader.readBy(userToken) ?: throw RuntimeException("User not found")
    }

    fun updateUserSeverity(userToken: String, severity: Severity) {
        commander.updateSeverity(UpdateSeverityCommand(userToken, severity))
    }
}