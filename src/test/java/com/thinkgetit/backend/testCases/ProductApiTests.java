package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.api.ProductApi;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ProductApiTests extends BaseTest {

    @Test
    public void verifyTrendingProductsWithSpecs() {
        Response response = ProductApi.getTrendingProducts();

        response.prettyPrint();

        response.then()
                .spec(successResponseSpec)
                .body("data.name", hasItem("Cargo Utility Shorts"));
    }
}