package com.thinkgetit.backend.api;

import com.thinkgetit.backend.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi extends BaseTest {
    protected static RequestSpecification getDefaultRequest() {
        return RestAssured.given()
                .spec(requestSpec);
    }
}