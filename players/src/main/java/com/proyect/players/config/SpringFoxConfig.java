package com.proyect.players.config;

import java.util.Collections;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SpringFoxConfig extends WebMvcAutoConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
   
        private ApiInfo apiDetails() {
            return new ApiInfo(
                    "Spring Boot Swagger API",
                    "API Rest Reference for Developers",
                    "1.0",
                    "https://google.com",
                    new Contact("Peter Parker", "https://google.com",
                    "peter@mail.com"), "MIT", "https://google.com", 
                    Collections.emptyList());
        }
}