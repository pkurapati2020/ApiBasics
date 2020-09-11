package org.prasanna.apacheClient;

import org.apache.http.client.methods.HttpGet;
import org.prasanna.utilities.GetHeaderUtility;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ResponseHeaderTests extends BaseTest{

    @Test
    public void serverTypeValidation() throws Exception {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        assertEquals("GitHub.com", GetHeaderUtility.getHeader(closeableHttpResponse, "Server"));
    }


}
