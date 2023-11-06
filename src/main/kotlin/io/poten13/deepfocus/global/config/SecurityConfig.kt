package io.poten13.deepfocus.global.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .antMatchers("/actuator/health").permitAll()
                    .antMatchers(*SWAGGER_URL).permitAll()
                    .anyRequest().authenticated()
            }
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        return http.build()
    }

    companion object {
        private val SWAGGER_URL = arrayOf(
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/**/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "**/swagger-ui.html",
            "/webjars/**",
            "/swagger-ui.html",
            "/api-docs",
            "/swagger-ui/**",
            "/api-docs/**"
        )
    }
}