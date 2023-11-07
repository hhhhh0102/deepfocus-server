package io.poten13.deepfocus.domain.user.entity

import io.poten13.deepfocus.domain.support.BaseTimeEntity
import io.poten13.deepfocus.domain.user.service.CreateUserCommand
import javax.persistence.*

@Entity
@Table(name = "tbl_user")
class User(
    @Column(length = 36, nullable = false, unique = true)
    val userToken: String,

    @Column(length = 20, nullable = false)
    var nickname: String,
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Long? = null

    protected constructor() : this(userToken = "", nickname = "")

    companion object {
        fun from(command: CreateUserCommand): User {
            return User(command.userToken, command.nickname)
        }
    }
}