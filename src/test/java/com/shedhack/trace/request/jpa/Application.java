package com.shedhack.trace.request.jpa;

import com.shedhack.trace.request.jpa.config.EnableTraceRequestJpa;
import com.shedhack.trace.request.jpa.config.TraceRequestJpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Test Application
 */
@SpringBootApplication
@EnableTraceRequestJpa
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
