package starter.petstore.util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class RestClient {

    // Static method to handle POST requests
    public static Response postRequest(String baseUri, String basePath, Object body) {
        return given()
                .baseUri(baseUri)
                .basePath(basePath)
                .body(body)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .post();
    }

    // Static method to handle GET requests
    public static Response getRequest(String baseUri, String basePath) {
        return given()
                .baseUri(baseUri)
                .basePath(basePath)
                .accept(ContentType.JSON)
                .get();
    }

    // Generic method to handle other types of HTTP methods if needed in the future (optional)
    public static Response request(String baseUri, String basePath, String method, Object body) {
        switch (method.toUpperCase()) {
            case "POST":
                return postRequest(baseUri, basePath, body);
            case "GET":
                return getRequest(baseUri, basePath);
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }
    }
}
