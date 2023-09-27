package com.juhao666.exception.demo.enums;

import com.juhao666.exception.demo.exceptions.asserts.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseEnum implements BusinessExceptionAssert {

    BAD_USER_TYPE(400000, "Bad user type."),
    USER_NOT_FOUND(400001, "User not found.");

    private int code;
    private String message;
}