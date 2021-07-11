package org.callblog.service;

import org.callblog.domain.Post;
import org.callblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired PostRepository postRepository;
    public List<Post> postList() {
        return postRepository.findAll();
    }
}
