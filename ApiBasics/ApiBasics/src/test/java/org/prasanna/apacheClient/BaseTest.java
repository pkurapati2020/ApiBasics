package org.prasanna.apacheClient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    public static final String BASE_ENDPOINT = "https://api.github.com";

    public CloseableHttpClient closeableHttpClient;
    public CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void Setup(){
        closeableHttpClient = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        closeableHttpClient.close();
        closeableHttpResponse.close();
    }
}
