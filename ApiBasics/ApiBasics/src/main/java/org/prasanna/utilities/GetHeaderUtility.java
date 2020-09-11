package org.prasanna.utilities;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;

public class GetHeaderUtility {

    public static String getHeader(CloseableHttpResponse response, String headerName) {
        List<Header> headers = Arrays.asList(response.getAllHeaders());
        Header header = headers.stream().filter(x -> x.getName().equalsIgnoreCase(headerName))
                                        .findFirst()
                                        .orElseThrow( () -> new RuntimeException("Header Not Found"));
        return header.getValue();
    }
}
