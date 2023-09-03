package com.cydeo.day3;


import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class ORDSApiTestsWithParameters {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://54.152.219.47:1000/ords/hr";
    }

    /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */

    @DisplayName("GET request to /countries with Query Param")
    @Test
    public void test1(){
      Response response= given().accept(ContentType.JSON)
                    .and().queryParam("q","{\"region_id\":2}")
                    .log().all()
            .when()
                    .get("/countries");

      assertEquals(200,response.statusCode());
      assertEquals("application/json",response.header("Content-Type"));
      assertTrue(response.body().asString().contains("United States of America"));

      response.prettyPrint();

    }
    /*
        Send a GET request to employees and get only employees who works as a IT_PROG

     */

    @DisplayName("GET request to /employees with Query Param")
    @Test
    public void test2(){
        Response response= given().accept(ContentType.JSON)
                .and().queryParam("q","{\"job_id\": \"IT_PROG\"}")
                .when().get("/employees");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.header("Content-Type"));
        assertTrue(response.body().asString().contains("IT_PROG"));

        response.prettyPrint();

    }


}
