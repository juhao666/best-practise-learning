package com.juhao666.exception.demo.controller;

import com.juhao666.exception.demo.model.UserRequest;
import com.juhao666.exception.demo.model.UserResponse;
import com.juhao666.exception.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity<UserResponse> getDetail(@RequestParam(value = "id", required = false) String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }
}
