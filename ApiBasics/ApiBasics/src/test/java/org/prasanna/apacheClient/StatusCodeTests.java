package org.prasanna.apacheClient;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class StatusCodeTests extends BaseTest {

    @Test
    public void basictest() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
        assertEquals(responseCode, 200);
    }

    @Test
    public void ValidateRateLimit() throws IOException {

        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
        assertEquals(responseCode, 200);
    }

    @Test
    public void searchRepositories() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/search/repositories?q=java");
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
        assertEquals(responseCode, 200);
    }

    @DataProvider
    private Object[][] endPoints() {
        return new Object[][] {
                {"/rate_limit"}, {"/search/repositories?q=java"}
        };
    }

    @Test(dataProvider = "endPoints")
    public void dataTests(String endPoint) throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + endPoint);
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        int responseCode = closeableHttpResponse.getStatusLine().getStatusCode();
        assertEquals(responseCode, 200);
    }


}
