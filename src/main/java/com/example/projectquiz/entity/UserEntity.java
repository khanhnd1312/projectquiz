package com.example.projectquiz.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "tbl_user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(name = "account_user", unique = true)
    private String accountUser;

    @Column(name = "password_user")
    private String passwordUser;

    @Column
    private String role;

}
