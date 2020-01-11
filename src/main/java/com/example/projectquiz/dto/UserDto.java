package com.example.projectquiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UserDto implements Serializable {
    private static final long serialVersionUID = 7586534150082640299L;
    private Long idUser;
    private String accountUser;
    private String passwordUser;
}
