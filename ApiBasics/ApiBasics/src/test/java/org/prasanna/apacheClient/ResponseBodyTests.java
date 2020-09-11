package org.prasanna.apacheClient;

import org.apache.http.client.methods.HttpGet;
import org.prasanna.entities.GitHubMain;
import org.prasanna.entities.RateLimit;
import org.prasanna.utilities.UnMarshallingUtility;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class ResponseBodyTests extends BaseTest {

    @Test
    public void validateGitHubMainBodyResponse() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        GitHubMain gitHubMain = UnMarshallingUtility.unMarshallling(closeableHttpResponse, GitHubMain.class);
        assertEquals(gitHubMain.getCurrentUserUrl(), "https://api.github.com/user");
    }

    @Test
    public void validateRateLimits() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "/rate_limit");
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        RateLimit rateLimit = UnMarshallingUtility.unMarshallling(closeableHttpResponse, RateLimit.class);
        assertEquals(rateLimit.getCoreLimit(), 60);
        assertEquals(rateLimit.getSearchLimit(), "10");
    }
}
