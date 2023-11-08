package io.poten13.deepfocus.global.constants

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class RoleType(
    val authorities: Set<GrantedAuthority>
) {
    ROLE_USER(setOf(SimpleGrantedAuthority("ROLE_USER")))
}