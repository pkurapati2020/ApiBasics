package org.prasanna.restAssured.nonBddFormat;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class BaseNonBDDTest {
    public static final String BASE_ENDPOINT = "http://localhost:3000";

    public RequestSpecification requestSpecification;

    @BeforeMethod
    public void setUp() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_ENDPOINT);
        requestSpecBuilder.setContentType(ContentType.JSON);
        var reqSpec = requestSpecBuilder.build();
        requestSpecification = given().spec(reqSpec);
    }


}
