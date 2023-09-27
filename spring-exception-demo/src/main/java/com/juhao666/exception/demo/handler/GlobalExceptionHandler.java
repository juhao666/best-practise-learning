package com.juhao666.exception.demo.handler;

import com.juhao666.exception.demo.enums.ResponseEnum;
import com.juhao666.exception.demo.exceptions.BusinessException;
import com.juhao666.exception.demo.model.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CommonResponse> bizExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("[GlobalExceptionHandler][BusinessException] exception. Request: {}", getRequestInfo(request), e);
        CommonResponse data = CommonResponse.builder().code(ResponseEnum.BAD_USER_TYPE.getCode()).message(ResponseEnum.BAD_USER_TYPE.getMessage()).build();
        return ResponseEntity.status(response.getStatus()).body(data);
    }


    private String getRequestInfo(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        sb.append("method=").append(request.getMethod()).append(", ");
        sb.append("uri=").append(request.getRequestURI()).append(", ");
        sb.append("remoteAddr=").append(request.getRemoteAddr()).append(", ");
        sb.append("headers=").append(getHeadersInfo(request)).append(", ");
        sb.append("params=").append(getRequestParameters(request));
        return sb.toString();
    }

    private String getHeadersInfo(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            sb.append(headerName).append("=").append(request.getHeader(headerName)).append("; ");
        }
        return sb.toString();
    }

    private String getRequestParameters(HttpServletRequest request){
        Map<String, String[]> parameters = request.getParameterMap();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            builder.append(key).append(":");
            for (int i = 0; i < values.length; i++) {
                builder.append(values[i]);
                if (i < values.length - 1) {
                    builder.append(", ");
                }
            }
            builder.append("&");
        }
        return builder.toString();
    }
}