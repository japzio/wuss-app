package com.japzio.wuss.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("WUSS App API")
                        .description("Web Url Shortening Service")
                        .version("v0.0.1-SNAPSHOT")
                        .license(new License().name("Apache 2.0").url("http://japzio.info")))
                        .externalDocs(
                                new ExternalDocumentation()
                                        .description("WUSS-App Documentation")
                                        .url("https://github.com/japzio/wuss-app")
                        );
    }
}
