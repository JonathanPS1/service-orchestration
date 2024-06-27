package com.marketplace.marketplace.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class customException extends RuntimeException {
    public customException(String message) {
        super(message);
    }
}
