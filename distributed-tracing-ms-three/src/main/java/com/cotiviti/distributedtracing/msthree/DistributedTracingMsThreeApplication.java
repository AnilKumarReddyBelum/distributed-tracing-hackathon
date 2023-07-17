package com.cotiviti.distributedtracing.msthree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DistributedTracingMsThreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedTracingMsThreeApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
