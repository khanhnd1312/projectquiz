package com.example.projectquiz.io.request.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotNull
    @NotBlank
    String accountUser;

    @NotNull
    @NotBlank
    String passwordUser;
}
