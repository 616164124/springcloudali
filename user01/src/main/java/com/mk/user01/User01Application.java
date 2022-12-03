package com.mk.user01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class User01Application {

    public static void main(String[] args) {
        SpringApplication.run(User01Application.class, args);
    }

}
