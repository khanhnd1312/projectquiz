package com.example.projectquiz.postapi;

import com.example.projectquiz.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostNewUserTest {
    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/createuser";
        RestAssured.port = 8080;
    }

    @Test
    void postNewStudent() {
        User user = new User();
        user.setIdUser(22);
        user.setAccountUser("accountTest");
        user.setPasswordUser("passtest");

        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .post();
        //res.prettyPrint();
        res.then().statusCode(201).body("msg ", equalTo("User added"));
    }
}
