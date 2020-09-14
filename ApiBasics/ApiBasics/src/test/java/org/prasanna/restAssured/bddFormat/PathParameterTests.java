package org.prasanna.restAssured.bddFormat;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PathParameterTests {

    @Test
    public void isTest() {
        given().
                contentType(ContentType.JSON).
        with().
                pathParam("postNumber", "1").
        when().
                get("http://localhost:3000/posts/{postNumber}").
         then().
                body("author", is("Me"));
    }
}
