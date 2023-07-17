package com.cotiviti.distributedtracing.msthree;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Clients and Payers Data API")
                        .description("Data for Payers and Clients available here.")
                        .version("1.0"));
    }
}
