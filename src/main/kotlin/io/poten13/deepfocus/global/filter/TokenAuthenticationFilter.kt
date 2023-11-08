package io.poten13.deepfocus.global.filter

import io.poten13.deepfocus.domain.user.service.UserReader
import io.poten13.deepfocus.global.constants.Constants.USER_TOKEN_HEADER_KEY
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TokenAuthenticationFilter(
    private val userReader: UserReader
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain
    ) {
        request.getHeader(USER_TOKEN_HEADER_KEY)?.takeIf { it.isNotBlank() }
            ?.let(userReader::readBy)
            ?.let { user ->
                val authentication = UsernamePasswordAuthenticationToken(user, null)
                SecurityContextHolder.getContext().authentication = authentication
                chain.doFilter(request, response)
            } ?: response.unauthorized()
    }

    private fun HttpServletResponse.unauthorized() {
        sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not authorized.")
    }
}