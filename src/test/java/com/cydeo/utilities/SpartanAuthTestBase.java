package com.cydeo.utilities;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

public abstract class SpartanAuthTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://54.152.219.47:7000";

    }
}
