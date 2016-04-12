package com.shedhack.trace.request.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Test Application
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.shedhack.trace.request.jpa.model",
        "com.shedhack.trace.request.jpa.service", "com.shedhack.trace.request.jpa.repository",
        "com.shedhack.trace.request.jpa.controller"})
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

}
