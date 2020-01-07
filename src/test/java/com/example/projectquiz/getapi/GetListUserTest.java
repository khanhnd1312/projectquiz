package com.example.projectquiz.getapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetListUserTest {
    @Before
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/user";
        RestAssured.port = 8080;
    }

    @Test
    public void getListUserTest() {
        Response res = given()
                .when()
                .get();

        res.prettyPrint();
        res.then().statusCode(200);

    }
}
