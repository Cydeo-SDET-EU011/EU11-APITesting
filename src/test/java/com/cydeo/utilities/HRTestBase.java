package com.cydeo.utilities;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;

public abstract class HRTestBase {
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we dont need to type each http method.
        baseURI = "http://54.152.219.47:1000/ords/hr";

        //get ip address from configuraitons
        String dbUrl = "jdbc:oracle:thin:@3.216.30.92:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

      //  DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }
}
