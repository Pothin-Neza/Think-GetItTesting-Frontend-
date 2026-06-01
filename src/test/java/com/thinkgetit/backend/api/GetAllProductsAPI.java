package com.thinkgetit.backend.api;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProductsAPI extends BaseTest {

    public static Response getProducts(String sortOrder, int limit) {
        return RestAssured.given()
                .spec(requestSpec)
                .queryParam("sort", sortOrder)
                .queryParam("limit", limit)
                .when()
                .get(Routes.GET_PRODUCTS);
    }
}
