package io.poten13.deepfocus.domain.user.repository

import io.poten13.deepfocus.domain.user.entity.Device
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceRepository: JpaRepository<Device, Long> {
    fun findByDeviceToken(deviceToken: String): Device?
}