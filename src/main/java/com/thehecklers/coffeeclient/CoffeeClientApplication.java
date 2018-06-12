package com.thehecklers.coffeeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CoffeeClientApplication {
    @Bean
    WebClient client() {
        return WebClient.create("http://localhost:8080/coffees");
    }

    public static void main(String[] args) {
        SpringApplication.run(CoffeeClientApplication.class, args);
    }
}
