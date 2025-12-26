package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Server productionServer = new Server();
        productionServer.setUrl("https://9396.pro604cr.amypo.ai");
        productionServer.setDescription("Production Server");

        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local Server");

        return new OpenAPI()
                .servers(List.of(productionServer, localServer))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("JWT Authentication")))
                .info(new Info()
                        .title("Smart Inventory Restock Predictor API")
                        .version("1.0")
                        .description("API for managing inventory, tracking consumption, and predicting restock dates")
                        .contact(new Contact()
                                .name("Inventory Team")
                                .email("support@inventory.com")));
    }
}