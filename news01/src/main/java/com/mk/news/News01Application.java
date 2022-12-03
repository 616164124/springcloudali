package com.mk.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class News01Application {

    public static void main(String[] args) {
        SpringApplication.run(News01Application.class, args);
    }

}
