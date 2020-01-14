package com.example.projectquiz.io;

import lombok.Getter;

@Getter
public enum ErrorResponse {
    NO_RECORD_FOUND("Record not found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    CREATE_FAILED("Create record failed"),
    UPDATE_FAILED("Update record failed"),
    DELETE_FAILED("Delete record failed");

    private String errorMessage;

    ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
