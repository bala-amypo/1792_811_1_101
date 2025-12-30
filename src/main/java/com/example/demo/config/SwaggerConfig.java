package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()

            .info(new Info()
                .title("JWT Demo API")
                .version("1.0")
                .description("Simple JWT Demo Project for Students"))

            // ✅ Multiple servers (IMPORTANT)
            .servers(List.of(
                new Server().url("http://localhost:8080").description("Local"),
                new Server().url("https://9107.pro604cr.amypo.ai").description("Production")
            ))

            // JWT Bearer configuration
            .components(new Components()
                .addSecuritySchemes("bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("Enter JWT token")));
    }
}
