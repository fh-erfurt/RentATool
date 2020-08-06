package de.rat.controller;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.*;
import static io.restassured.authentication.FormAuthConfig.springSecurity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void checkStatusCode200ForPage_Login() {
        given().when().request("GET", "/login").then().statusCode(200);
    }

    @Test
    public void checkStatusCode200ForPage_LoginSuccessfull() {
        given().when().request("GET", "/loginSuccessfull").then().statusCode(200);
    }

    //TODO: Test doesnt work. Here we have the same problem like in the api tests
    @Test
    public void testTheLogin() {
        given().auth().form("customer1@test.de", "1234", springSecurity().withLoggingEnabled(new LogConfig())).when().get();
    }
}
