package com.fsts.gestion_factures.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private String entity;
    private String field;
    private String value;

    public ResourceNotFoundException(String entity, String field, String value) {
        super(String.format("%s Not Found with %s:%s", entity, field, value));
        this.entity = entity;
        this.field = field;
        this.value = value;
    }

    public ResourceNotFoundException(String message) {
        super(message);

    }
}


