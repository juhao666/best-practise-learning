package com.juhao666.exception.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringExceptionDemoApplication {

    public static void main(String[] args) {
        try {
            log.info("spring exception demo application is starting...");
            SpringApplication.run(SpringExceptionDemoApplication.class, args);
        } catch (Exception e) {
            log.info("spring exception demo application start failed", e);
        }
    }

}
