package org.callblog.service;

import org.callblog.configuration.CallblogCommonException;
import org.callblog.domain.CommonInfo;
import org.callblog.domain.User;
import org.callblog.model.response.ErrorResponse;
import org.callblog.model.response.StatusEnum;
import org.callblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired UserRepository userRepository;

    public void signUp(User user) {

        this.checkDuplication(user);
        user.setCommonInfo(new CommonInfo());
        userRepository.save(user);
    }

    public void checkDuplication(User user) {
        if (userRepository.findByEmailEquals(user.getEmail()).isPresent()) {
            throw new CallblogCommonException(new ErrorResponse(StatusEnum.DUPLICATE_EMAIL, "D001", "이미 가입된 email 입니다."));
        }
    }


}
