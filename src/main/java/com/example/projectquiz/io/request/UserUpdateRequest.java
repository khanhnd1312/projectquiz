package com.example.projectquiz.io.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UserUpdateRequest {

    @NotBlank
    @NotNull
    private String accountUser;

}
