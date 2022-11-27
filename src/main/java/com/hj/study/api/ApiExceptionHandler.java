package com.hj.study.api;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleException(Exception e, HttpServletResponse response) {
        log.error("Exception handleException : " + e);

        return new ExceptionResponse(e.getMessage());
    }

    @ExceptionHandler(ApiException.class)
    public ExceptionResponse handleApiException(Exception e, HttpServletResponse response) {
        log.error("ApiException handleException : " + e);

        return new ExceptionResponse(e.getMessage());
    }

    @Getter
    @Setter
    public class ExceptionResponse {
        private String message;

        public ExceptionResponse(String message) {
            this.message = message;
        }

    }
}
