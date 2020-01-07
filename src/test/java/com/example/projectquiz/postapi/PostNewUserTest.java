package com.example.projectquiz.postapi;

import com.example.projectquiz.model.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostNewUserTest {

//    @BeforeAll
//    static void init() {
//        RestAssured.baseURI = "http://localhost";
//        //RestAssured.basePath = "/createuser";
//        RestAssured.port = 8080;
//    }
//
//    @Test
//    public void postNewStudent() {
//        User user = new User();
//        user.setIdUser(22);
//        user.setAccountUser("accountTest");
//        user.setPasswordUser("passtest");
//
//        String testBody = "{    \"idUser\": 22,    \"accountUser\": \"democreateuser\",    \"passwordUser\": \"demopass2\"}";
//
//        Response res = given()
//                .contentType(ContentType.JSON)
//                .body(testBody)
//                .when()
//                .post("/createuser");
//        //res.prettyPrint();
//        res.then().statusCode(201).body("msg ", equalTo("User added"));
//    }
@Test
public void createEmployee() {

    RestAssured.baseURI = "localhost:8080";

    String testBody = "{    \"idUser\": 22,    \"accountUser\": \"democreateuser\",    \"passwordUser\": \"demopass2\"}";


    Response response = null;

    try {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(testBody)
                .post("/createuser");
    } catch (Exception e) {
        e.printStackTrace();
    }

//    System.out.println("Response :" + response.asString());
//    System.out.println("Status Code :" + response.getStatusCode());
//    System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));


    Assert.assertEquals(200, response.getStatusCode());
}
}
