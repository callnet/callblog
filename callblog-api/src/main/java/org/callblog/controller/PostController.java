package org.callblog.controller;

import org.callblog.domain.Post;
import org.callblog.model.response.BasicResponse;
import org.callblog.model.response.ResultResponse;
import org.callblog.model.response.StatusEnum;
import org.callblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/board")
public class PostController {

    @Autowired PostService postService;

    @GetMapping(path = "/post")
    public ResponseEntity<? extends BasicResponse> selectPostList(@RequestBody @Valid Post post) {
        // TODO: 2021-07-12 페이징 처리 
        List<Post> postList = postService.selectPostList();

        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK));
    }

    @GetMapping(path = "/post/{id}")
    public ResponseEntity<? extends BasicResponse> selectPost(@PathVariable("id") Long id) {

        Post resPost = postService.selectPost(id);

        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK, resPost));
    }


    @PostMapping(path = "/post")
    public ResponseEntity<? extends BasicResponse> savePost(@RequestBody @Valid Post post) {
        postService.savePost(post);

        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK));
    }







}
