package io.poten13.deepfocus.domain.user.entity

import io.poten13.deepfocus.domain.support.BaseTimeEntity
import io.poten13.deepfocus.domain.user.service.CreateDeviceCommand
import javax.persistence.*

@Entity
@Table(name = "tbl_device")
class Device(
    @Column(name = "device_token", nullable = false, unique = true)
    val deviceToken: String,

    @JoinColumn(name = "user_id", nullable = false)
    val userId: Long?,
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    protected constructor(): this("", null)

    companion object {
        fun from(command: CreateDeviceCommand): Device {
            return Device(command.deviceToken, command.userId)
        }
    }
}