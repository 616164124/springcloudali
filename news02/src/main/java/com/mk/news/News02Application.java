package com.mk.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class News02Application {

    public static void main(String[] args) {
        SpringApplication.run(News02Application.class, args);
    }

}
