package com.example.projectquiz.postapi;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static io.restassured.RestAssured.given;

public class DeleteUserEntityTest {
    @BeforeAll
    static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/user";
        RestAssured.port = 8080;
    }

    @Test
    public void deleteAnExistingUser() {

//        UserEntity userEntity = new UserEntity();
//        userEntity.setIdUser(232);
//        userEntity.setAccountUser("accountTest");
//        userEntity.setPasswordUser("passtest");
//
//        given().log().all().contentType(ContentType.JSON).when().body(userEntity).post();
//
//
//        Response res = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .delete("/{id}", userEntity.getIdUser());
//
//        res.then().statusCode(204);
    }
}
