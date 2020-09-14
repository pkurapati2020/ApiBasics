package org.prasanna.restAssured.nonBddFormat;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.prasanna.entities.Post;
import org.prasanna.utilities.UnMarshallingUtility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostTests extends BaseNonBDDTest {

    @Test
    public void isTest() throws URISyntaxException {
        Response response = requestSpecification.get(new URI("/posts/1"));
        assertThat(response.getBody().jsonPath().get("author"), equalTo("Me"));
    }

    @Test
    public void deserializeJsonResponse() throws URISyntaxException, IOException {
        Response response = requestSpecification.get(new URI("/posts/1"));

//        Post post1 = response.getBody().as(Post.class);
//        assertThat(post1.getAuthor(), equalTo("Me"));

        //or

        Post post2 = UnMarshallingUtility.unMarshallling(response, Post.class);
        assertThat(post2.getAuthor(), equalTo("Me"));
    }
}
