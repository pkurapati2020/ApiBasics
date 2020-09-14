package org.prasanna.utilities;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class UnMarshallingUtility {

    //Using HttpClient
    public static <T> T unMarshallling(CloseableHttpResponse response, Class<T> genericClass) throws IOException {
        String jsonBody = EntityUtils.toString(response.getEntity());
        return  new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, genericClass);
    }

    public static <T> T unMarshallling(Response response, Class<T> genericClass) throws IOException {
        String jsonBody = response.asString();
        return  new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, genericClass);
    }
}
