package com.example.projectquiz.getapi;

import com.example.projectquiz.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/user";
        RestAssured.port = 8080;
    }

    @Test
    public void deleteAnExistingUser() {

        User user = new User();
        user.setIdUser(232);
        user.setAccountUser("accountTest");
        user.setPasswordUser("passtest");

        given().log().all().contentType(ContentType.JSON).when().body(user).post();

        // Act: Call API delete student
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/{id}", user.getIdUser());

        // Assert
        res.then().statusCode(204);
    }
}
