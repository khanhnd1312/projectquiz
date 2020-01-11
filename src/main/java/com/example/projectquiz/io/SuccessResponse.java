package com.example.projectquiz.io;

import lombok.Getter;

@Getter
public enum SuccessResponse {
    FOUND_RECORD("Record found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    CREATE_SUCCESS("Create record success"),
    UPDATE_SUCCESS("Update record success"),
    DELETE_SUCCESS("Delete record success");

    private String successMessage;
    SuccessResponse(String successMessage){
        this.successMessage = successMessage;
    }
}
