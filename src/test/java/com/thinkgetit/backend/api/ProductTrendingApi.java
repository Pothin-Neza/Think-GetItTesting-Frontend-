package com.thinkgetit.backend.api;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProductTrendingApi extends BaseTest {

    // GET /products/trending
    public static Response getTrendingProducts() {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .get(Routes.GET_TRENDING);
    }


}