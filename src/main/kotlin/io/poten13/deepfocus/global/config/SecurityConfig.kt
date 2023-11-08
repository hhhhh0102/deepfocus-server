package io.poten13.deepfocus.global.config

import io.poten13.deepfocus.global.filter.TokenAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsUtils

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val tokenAuthenticationFilter: TokenAuthenticationFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { request ->
                request
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                request
                    .antMatchers("/actuator/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/api/v1/users/login").permitAll()
                    .antMatchers(*SWAGGER_URL).permitAll()
                    .anyRequest().authenticated()
            }
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilterAfter(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
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