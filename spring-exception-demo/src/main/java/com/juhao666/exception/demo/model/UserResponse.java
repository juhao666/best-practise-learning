package com.juhao666.exception.demo.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    String Id;
    String username;
    String aliasName;
    String phone;
    String email;
}
