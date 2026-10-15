package com.api.blog.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResouceNotFoundException(String message) {
        super(message);
    }
}