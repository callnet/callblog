package org.callblog.controller;

import org.callblog.model.request.LoginRequest;
import org.callblog.model.response.BasicResponse;
import org.callblog.model.response.ResultResponse;
import org.callblog.model.response.ErrorResponse;
import org.callblog.model.response.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @PostMapping(path = "/login")
    public ResponseEntity<? extends BasicResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        // TODO: 2021-06-26 로그인 검증 DB조회

        //validation 체크
        if(loginRequest.getUserid()==null || loginRequest.getUserid().isBlank()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse(StatusEnum.BAD_REQUEST, "V001", "userid 는 필수입니다."));
        }
        if(loginRequest.getPassword()==null || loginRequest.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ErrorResponse(StatusEnum.BAD_REQUEST, "V001", "password 는 필수입니다."));
        }

        if(!"test".equals(loginRequest.getUserid()) || !"test".equals(loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(StatusEnum.BAD_REQUEST, "A001", "테스트 회원 정보가 아닙니다."));
        }
        return ResponseEntity.ok().body(new ResultResponse<>(StatusEnum.OK, loginRequest));
    }
}
