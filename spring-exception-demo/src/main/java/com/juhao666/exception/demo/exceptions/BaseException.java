package com.juhao666.exception.demo.exceptions;

import com.juhao666.exception.demo.enums.IResponseEnum;

public class BaseException extends RuntimeException {

    IResponseEnum responseEnum;
    Object[] args;


    public BaseException(String message) {
        super(message);
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message) {
        super(message);
        this.responseEnum = responseEnum;
        this.args = args;
    }

    public BaseException(IResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(message, cause);
        this.responseEnum = responseEnum;
        this.args = args;
    }
}

