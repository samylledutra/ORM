package com.example.final_project.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Gestão de Leads e Campanhas")
                .version("1.0")
                .description("Documentação da API para gerenciar leads e campanhas para a loja de pudins.")
                .termsOfService("http://mytersm.com")
            );
    }
}
