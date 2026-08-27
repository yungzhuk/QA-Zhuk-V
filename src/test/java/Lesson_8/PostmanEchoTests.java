package Lesson_8;

import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {
    @Test
    public void testGetRequest() {
        given()
                .log().all()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")  // ← полный URL
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawText() {
        String data = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(data)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(data));
    }

    @Test
    public void testPostFormData() {
        String jsonBody = "{ \"foo1\": \"bar1\", \"foo2\": \"bar2\" }";

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }

    @Test
    public void testPutRequestText() {
        String data = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(data)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(data))
                .body("json", nullValue());
    }

    @Test
    public void testPatchRequestText() {
        String data = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(data)
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(data))
                .body("json", nullValue()); // PATCH с text/plain не возвращает json
    }

    @Test
    public void testDeleteRequestText() {
        String data = "This is expected to be sent back as part of response body.";

        given()
                .header("Content-Type", "text/plain")
                .body(data)
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(data))
                .body("json", nullValue());
    }

}
