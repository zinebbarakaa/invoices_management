package com.fsts.gestion_factures.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class InvalidInputException extends RuntimeException {
    private String message;

    public InvalidInputException(String message) {
        super(message);
        this.message = message;
    }

}

