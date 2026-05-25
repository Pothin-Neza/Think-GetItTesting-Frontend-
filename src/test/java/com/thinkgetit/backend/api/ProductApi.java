package com.thinkgetit.backend.api;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ProductApi extends BaseTest {

    // GET /products/trending
    public static Response getTrendingProducts() {
        return RestAssured.given()
                .spec(requestSpec)
                .when()
                .get(Routes.GET_TRENDING);
    }

    public static Response getProducts(String sortOrder, int limit) {
        return RestAssured.given()
                .spec(requestSpec)
                .queryParam("sort", sortOrder)
                .queryParam("limit", limit)
                .when()
                .get(Routes.GET_PRODUCTS);
    }
}