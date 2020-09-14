package org.prasanna.restAssured.bddFormat;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PostRequestTests {
    @Test
    public void isTest() {
        Map<String, String> content = Map.of (
          "id", "4",
          "title", "Talos",
          "author", "Them"
        );
        given().
                contentType(ContentType.JSON).
        with().
                body(content).
        when().
                post("http://localhost:3000/posts/").
        then().
                body("author", is("Them"));
    }
}
