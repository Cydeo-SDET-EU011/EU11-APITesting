package com.cydeo.day8;

import io.restassured.http.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

public class BookItTest {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "https://qa.api.book-it.today";

    }

    //create BookItUtil then create a method, that accepts email and password return token Bearer +yourToken as a String

    String accessToken = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

    @DisplayName("GET all campuses")
    @Test
    public void testAuth1(){
        //how to pass bearer token for bookit ? use header method to give as key value header
      given().
                header("Authorization",accessToken)
                .and().accept(ContentType.JSON)
        .when()
                .get("/api/campuses")
        .then()
                .statusCode(200)
                .log().all();

    }


}
