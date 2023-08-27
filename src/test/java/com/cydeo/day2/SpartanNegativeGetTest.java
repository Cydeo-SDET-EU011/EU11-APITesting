package com.cydeo.day2;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegativeGetTest {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://54.152.219.47:8000";
    }

    /*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8
    */

    @DisplayName("GET request to /api/spartans/10")
    @Test
    public void test1(){
        Response response = given()
                                    .accept(ContentType.XML)
                            .when()
                                    .get("/api/spartans/10");

        //verify status code is 406
        assertEquals(406,response.statusCode());
        //verify content type
        assertEquals("application/xml;charset=UTF-8",response.contentType());
    }

}
