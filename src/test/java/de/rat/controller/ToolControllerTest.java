package de.rat.controller;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToolControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost/api";
        RestAssured.port = port;
    }

    @Test
    public void checkStatusCode200ForPage_ToolManagement() {
        given().when().request("GET", "/toolManagement").then().statusCode(200);
    }

    @Test
    public void checkStatusCode200ForPage_Tools() {
        given().when().request("GET", "/tools").then().statusCode(200);
    }

    @Test
    public void whenRequestGetWithId_thenOK() {
        given().when().request("GET", "/chooseStation/10000")
                .then().statusCode(200);
    }

}
