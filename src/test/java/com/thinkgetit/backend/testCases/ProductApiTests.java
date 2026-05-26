package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.BaseApi;
import com.thinkgetit.backend.api.ProductTrendingApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ProductApiTests extends BaseApi {

    @Test
    public void verifyTrendingProductsWithSpecs() {
        Response response = ProductTrendingApi.getTrendingProducts();

        response.prettyPrint();

        response.then()
                .spec(successResponseSpec)
                .body("data.name", hasItem("Cargo Utility Shorts"));
    }
}