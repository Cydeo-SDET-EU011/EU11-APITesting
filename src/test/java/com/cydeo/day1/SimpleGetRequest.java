package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    // replace the ip address you get from jenkins server with below one.
    String url = "http://3.216.30.92:8000/api/spartans";

    @Test
    public void test1(){
        //send a get request and save response inside the Response object
        Response response = RestAssured.get(url);

        //print response status code
        System.out.println(response.statusCode());

        //print response body
        response.prettyPrint();

    }





}
