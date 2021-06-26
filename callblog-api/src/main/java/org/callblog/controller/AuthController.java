package org.callblog.controller;

import org.callblog.model.request.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @PostMapping(path = "/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest) {
        // TODO: 2021-06-26 로그인 검증, test 코드, 리턴 객체 공통화 
        return "";
    }
}
