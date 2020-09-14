package org.prasanna.restAssured.nonBddFormat;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteRequestTests extends BaseNonBDDTest {
    @Test
    public void deletePostTest() throws URISyntaxException {
        Response response = requestSpecification.delete(new URI("/posts/5"));
        assertThat(response.statusCode(), equalTo(200));
    }
}
