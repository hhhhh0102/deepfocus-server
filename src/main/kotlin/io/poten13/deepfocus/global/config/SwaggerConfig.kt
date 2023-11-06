package io.poten13.deepfocus.global.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .info(Info()
                .title(API_NAME)
                .version(API_VERSION)
                .description(API_DESCRIPTION))
            .addSecurityItem(SecurityRequirement().addList("api_key"))
            .components(
                io.swagger.v3.oas.models.Components()
                    .addSecuritySchemes("api_key",
                        SecurityScheme()
                            .name("api_key")
                            .type(SecurityScheme.Type.APIKEY)
                            .`in`(SecurityScheme.In.HEADER)
                            .name("X-User-Token")
                    )
            )
    }

    companion object {
        const val API_NAME          = "DEEPFOCUS API"
        const val API_VERSION       = "1.0.0"
        const val API_DESCRIPTION   = "DEEPFOCUS API"
    }
}