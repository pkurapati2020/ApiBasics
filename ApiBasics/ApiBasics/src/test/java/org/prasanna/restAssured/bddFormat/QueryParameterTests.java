package org.prasanna.restAssured.bddFormat;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class QueryParameterTests {

    @Test
    public void containsTest() {
        given().
                contentType(ContentType.JSON).
                queryParam("id", 1).
        when().
                get("http://localhost:3000/posts/").
        then().
                body("author", contains("Me"));
    }

    @Test
    public void hasItemsTest() {
        given().
                contentType(ContentType.JSON).
                queryParam("_page", "1").
        when().
                get("http://localhost:3000/posts/").
        then().
                body("author", hasItems("Me", "Him", "Her"));
    }
}
