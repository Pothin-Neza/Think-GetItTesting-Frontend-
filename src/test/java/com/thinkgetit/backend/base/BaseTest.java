package com.thinkgetit.backend.base;

import com.thinkgetit.backend.routes.Routes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification successResponseSpec;

    @BeforeClass
    public static void setupSpecifications() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Routes.BASE_URL)
                .addHeader("Accept", "application/json") // Tells the server we want JSON back
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }
}