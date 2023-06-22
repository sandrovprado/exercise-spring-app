package com.sandro.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequestValidationExecption extends RuntimeException{
    public RequestValidationExecption(String message) {
        super(message);
    }
}
