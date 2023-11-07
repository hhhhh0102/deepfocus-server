package io.poten13.deepfocus.domain.user.dto

import io.poten13.deepfocus.domain.user.entity.Device

data class DeviceModel(
    val deviceId: Long,
    val deviceToken: String,
    val userId: Long
) {
    companion object {
        fun from(device: Device): DeviceModel {
            return DeviceModel(device.id!!, device.deviceToken, device.userId!!)
        }
    }
}