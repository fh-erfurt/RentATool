
package de.rat.controller;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static io.restassured.RestAssured.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost/api";
        RestAssured.port = port;
    }

    @Test
    public void checkStatusCode200ForPage_Index() {
        given().when().request("GET", "/").then().statusCode(200);
    }
}
