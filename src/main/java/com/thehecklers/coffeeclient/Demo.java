package com.thehecklers.coffeeclient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Component
public class Demo {
    private final WebClient client;

    Demo(WebClient client) {
        this.client = client;
    }

    @PostConstruct
    private void run() {
        client.get()
                .retrieve()
                .bodyToFlux(Coffee.class)
                .filter(coffee -> coffee.getName().equalsIgnoreCase("tim hortons"))
                .flatMap(coffee -> client.get()
                        .uri("/{id}/orders", coffee.getId())
                        .retrieve()
                        .bodyToFlux(CoffeeOrder.class))
                .subscribe(System.out::println);
    }
}
