import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PostmanEcho {

    @Test
    void shouldSendPostRequest() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Content-Type","application/json; charset=utf-8")
                .body("data", equalTo("Hello"))
                .body("headers.content-length", equalTo("5"))
        ;
    }
}
