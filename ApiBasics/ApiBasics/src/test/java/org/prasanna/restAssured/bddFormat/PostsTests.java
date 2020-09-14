package org.prasanna.restAssured.bddFormat;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostsTests {
    @Test
    public void isTest() {
        given().
                contentType(ContentType.JSON).
        when().
                get("http://localhost:3000/posts/1").
        then().
                body("author", is("Me"));
    }

    @Test
    public void hasItemsTest() {
        given().
                contentType(ContentType.JSON).
        when().
                get("http://localhost:3000/posts/").
        then().
                body("author", hasItems("Me", "Him", "Her"));
    }

    @Test
    public void containsInAnyOrderTest() {
        given().
                contentType(ContentType.JSON).
        when().
                get("http://localhost:3000/posts/").
        then().
                body("author", containsInAnyOrder("Her", "Me", "Him"));
    }

    @Test
    public void statusCodeTest() {
        given().
                contentType(ContentType.JSON).
        when().
                get("http://localhost:3000/posts/").
        then().
                statusCode(200);
    }
}
