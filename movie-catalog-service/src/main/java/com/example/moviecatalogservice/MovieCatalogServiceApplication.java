package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogServiceApplication {

    // For synchronous call to api (Support for RestTemplates ended)
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    // For asynchronous call to api (supported from community and can also call api synchronously)
    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }


    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

}
