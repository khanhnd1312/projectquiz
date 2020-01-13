package com.example.projectquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSession implements Serializable {

    private Long idUser;
    private String accountUser;
    private String role;

    @Override
    public String toString() {
        return "UserSession{" +
                "idUser=" + idUser +
                ", accountUser='" + accountUser + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
