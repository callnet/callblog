package org.callblog.domain;

import org.callblog.CallblogDomainApplication;
import org.callblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@SpringBootTest(classes = CallblogDomainApplication.class)
@ActiveProfiles("dev")
public class ProfilesTest {
    @Autowired
    Environment environment;

    @Autowired
    UserRepository userRepository;

    @Test
    void envTest() {
        Arrays.stream(environment.getActiveProfiles()).forEach(System.out::println);
    }
}
