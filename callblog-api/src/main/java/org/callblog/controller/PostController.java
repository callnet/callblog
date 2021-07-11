package org.callblog.controller;

import org.callblog.domain.Post;
import org.callblog.model.response.BasicResponse;
import org.callblog.model.response.ResultResponse;
import org.callblog.model.response.StatusEnum;
import org.callblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/post")
public class PostController {

    @Autowired PostService postService;

    @PostMapping(path = "/list")
    public ResponseEntity<? extends BasicResponse> postList(@RequestBody @Valid Post post) {
        // TODO: 2021-07-12 페이징 처리 
        List<Post> postList = postService.postList();

        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK));
    }

}
