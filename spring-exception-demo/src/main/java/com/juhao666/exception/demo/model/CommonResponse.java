package com.juhao666.exception.demo.model;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CommonResponse {
    int code;
    String message;
}
