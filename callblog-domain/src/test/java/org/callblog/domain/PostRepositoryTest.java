package org.callblog.domain;

import org.callblog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private TestEntityManager em;
    @Autowired
    private PostRepository postRepository;

    @Test
    void insertPost() {
        CommonInfo commonInfo = new CommonInfo();

        Post post = Post.builder()
                .title("제목")
                .contents("내용")
                .commonInfo(commonInfo)
                .build();

        em.persist(post);
        em.flush();

        post.setContents("내용 수정");
        Post resPost = postRepository.save(post);
        em.flush();

        System.out.println(resPost);
        assertEquals(post.getTitle(), resPost.getTitle());
        assertEquals(post.getContents(), resPost.getContents());


    }

}
