package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class postmanEchoTest1 {
    @Test
    void shouldReturnPostmanEcho() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some value") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some value"))
        ;
    }

    @Test
    void shouldReturnPostmanEchoText() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Privet")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Privet"))
        ;
    }


}
