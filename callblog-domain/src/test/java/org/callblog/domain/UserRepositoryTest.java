package org.callblog.domain;

import org.callblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@Transactional(propagation = Propagation.NOT_SUPPORTED) //테스트종료후 롤백하지 않음
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //이 설정이 없으면 @ActiveProfiles("local") 무시되고 내장된 임베디드 DB 사용
//@ActiveProfiles("local")
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
