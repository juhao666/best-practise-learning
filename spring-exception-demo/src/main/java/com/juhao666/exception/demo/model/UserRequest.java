package com.juhao666.exception.demo.model;


import lombok.Builder;
import lombok.Data;

@Data
public class UserRequest {
    String Id;
    String username;
    String aliasName;
    String phone;
    String email;
}
