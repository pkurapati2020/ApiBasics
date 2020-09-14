package org.prasanna.restAssured.nonBddFormat;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestTests extends BaseNonBDDTest {
    @Test
    public void isTest() throws URISyntaxException {
        Map<String, String> content = Map.of (
                "id", "5",
                "title", "UiPath",
                "author", "Us"
        );

        requestSpecification.body(content);
        Response response = requestSpecification.post(new URI("/posts"));
        assertThat(response.getBody().jsonPath().get("author"), equalTo("Us"));
    }
}
