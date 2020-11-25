package ru.netology.postman;

import io.restassured.specification.Argument;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostManApiTest {
    @Test
    void shouldReturnQueryAndGetQuery() {
        given()
                .baseUri("https://postman-echo.com")
                .body("HELLO")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("HELLO"))
        ;

    }

    @Test
    void shouldReturnRusQueryAndGetRusQuery(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("привет")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("прювет"))
        ;
    }


}
