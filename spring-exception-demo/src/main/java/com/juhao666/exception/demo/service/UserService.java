package com.juhao666.exception.demo.service;

import com.juhao666.exception.demo.enums.ResponseEnum;
import com.juhao666.exception.demo.model.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //todo best practice to define an interface here
    public UserResponse findUserById(String id) {
        ResponseEnum.USER_NOT_FOUND.assertNotNull(id);
        return UserResponse.builder()
                .Id(id)
                .username("Erik")
                .aliasName("juhao")
                .phone("13800138000")
                .email("juhao@demo.com")
                .build();
    }
}