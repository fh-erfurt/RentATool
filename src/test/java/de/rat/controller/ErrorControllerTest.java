package de.rat.controller;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ErrorControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void checkStatusCode200ForPage_Error() {
        given().when().request("GET", "/error").then().statusCode(200);
    }

    @Test
    public void checkStatusCode200ForPage_Error403() {
        given().when().request("GET", "/error403").then().statusCode(200);
    }
}