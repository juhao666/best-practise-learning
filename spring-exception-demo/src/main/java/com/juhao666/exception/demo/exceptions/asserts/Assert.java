package com.juhao666.exception.demo.exceptions.asserts;

import com.juhao666.exception.demo.exceptions.BaseException;

public interface Assert {
    BaseException exception(Object... args);

    BaseException exception(Throwable t, Object... args);

    default void assertNotNull(String var) {
        if (var == null || var.length() == 0) {
            throw exception("the object is empty");
        }
    }


    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw exception("the object {} is empty", args);
        }
    }
}