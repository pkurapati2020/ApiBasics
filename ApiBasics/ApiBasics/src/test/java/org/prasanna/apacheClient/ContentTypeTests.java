package org.prasanna.apacheClient;

import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ContentTypeTests extends BaseTest {

    @Test
    public void contentTypeValidation() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        closeableHttpResponse = closeableHttpClient.execute(httpGet);
        Header contentType = closeableHttpResponse.getEntity().getContentType();
        assertEquals(contentType.getValue(), "application/json; charset=utf-8");

        ContentType contentType1 = ContentType.getOrDefault(closeableHttpResponse.getEntity());
        assertEquals(contentType1.getMimeType(), "application/json");
    }
}
