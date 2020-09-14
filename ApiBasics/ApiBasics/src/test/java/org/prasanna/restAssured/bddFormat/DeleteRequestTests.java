package org.prasanna.restAssured.bddFormat;

import io.restassured.http.ContentType;
import org.hamcrest.core.IsNot;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DeleteRequestTests {

    @Test
    public void isTest() {
        given().
                contentType(ContentType.JSON).
        with().
                pathParam("postNumber", "4").
        when().
                delete("http://localhost:3000/posts/{postNumber}").
        then().
                statusCode(200);
    }
}
