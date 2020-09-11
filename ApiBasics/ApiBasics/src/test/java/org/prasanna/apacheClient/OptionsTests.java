package org.prasanna.apacheClient;

import org.apache.http.client.methods.HttpOptions;
import org.prasanna.utilities.GetHeaderUtility;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class OptionsTests extends BaseTest {

    @Test
    public void validateOptionsForGitHubMain() throws IOException {
        HttpOptions httpOptions = new HttpOptions(BASE_ENDPOINT);
        closeableHttpResponse = closeableHttpClient.execute(httpOptions);
        String headerValue = GetHeaderUtility.getHeader(closeableHttpResponse, "Access-Control-Allow-Methods");
        assertEquals(headerValue, "GET, POST, PATCH, PUT, DELETE");
    }
}
