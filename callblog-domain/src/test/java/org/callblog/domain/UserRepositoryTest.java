package org.callblog.domain;

import org.callblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    private UserRepository userRepository;

    @Test
    void insertUser() {

        User user = User.builder()
                .email("test@test.com")
                .userId("test")
                .password("test")
                .name("테스트")
                .commonInfo(new CommonInfo())
                .build();

        userRepository.save(user);
        userRepository.flush();
        em.detach(user);

        User resUser = userRepository.getOne(user.getSeq());

        assertEquals(user.getEmail(), resUser.getEmail());
    }
}
