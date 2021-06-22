package org.callblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //@CreatedDate 를 사용하기 위함
@SpringBootApplication
public class callblogDomainApplication {
    public static void main(String[] args) {
        SpringApplication.run(callblogDomainApplication.class, args);
    }
}
