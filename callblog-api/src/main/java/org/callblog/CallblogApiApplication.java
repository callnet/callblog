package org.callblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class CallblogApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CallblogApiApplication.class, args);
    }
}
