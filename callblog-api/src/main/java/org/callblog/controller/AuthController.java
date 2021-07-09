package org.callblog.controller;

import org.callblog.configuration.ValidationGroups;
import org.callblog.domain.User;
import org.callblog.model.response.BasicResponse;
import org.callblog.model.response.ErrorResponse;
import org.callblog.model.response.ResultResponse;
import org.callblog.model.response.StatusEnum;
import org.callblog.repository.UserRepository;
import org.callblog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @Autowired AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<? extends BasicResponse> login(@RequestBody @Valid User user) {
        User loginUser = authService.login(user);
        // TODO: 2021-07-09 토큰생성
        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK, "S002", "로그인 성공", loginUser));
    }

    @PostMapping(path = "/signUp")
    public ResponseEntity<? extends BasicResponse> signUp(
            @RequestBody @Validated(ValidationGroups.signUpGroup.class) User user) {
        authService.signUp(user);
        return ResponseEntity.ok()
                .body(new ResultResponse<>(StatusEnum.OK, "S001", "회원가입 성공", user));
    }
}
