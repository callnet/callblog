package org.callblog.api.service;


import org.callblog.domain.CommonInfo;
import org.callblog.domain.User;
import org.callblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest
@ActiveProfiles("dev")
public class AuthServiceTest {

    @Autowired UserRepository userRepository;

    @Test
    void userSave() {
        User user = User.builder()
                .email("test@test.com")
                .userId("test")
                .password("test")
                .name("테스트")
                .commonInfo(new CommonInfo())
                .build();

        userRepository.save(user);
    }
}
