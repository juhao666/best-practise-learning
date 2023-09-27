package com.juhao666.exception.demo.exceptions.asserts;

import com.juhao666.exception.demo.enums.IResponseEnum;
import com.juhao666.exception.demo.exceptions.BaseException;
import com.juhao666.exception.demo.exceptions.BusinessException;

import java.text.MessageFormat;

public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException exception(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException exception(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);
        return new BusinessException(this, args, msg, t);
    }

}