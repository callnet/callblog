package org.callblog.service;

import org.callblog.configuration.CallblogCommonException;
import org.callblog.domain.Post;
import org.callblog.model.response.ErrorResponse;
import org.callblog.model.response.StatusEnum;
import org.callblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired PostRepository postRepository;

    public List<Post> selectPostList() {
        return postRepository.findAll();
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post selectPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> {
            throw new CallblogCommonException(new ErrorResponse<>(StatusEnum.BAD_REQUEST, "E901", "게시글이 존재하지 않습니다."));
        });
    }
}
