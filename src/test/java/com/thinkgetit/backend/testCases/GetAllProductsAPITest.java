package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.BaseApi;
import com.thinkgetit.backend.api.GetAllProductsAPI;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;


public class GetAllProductsAPITest extends BaseApi {

    @Test
    public void getAllProducts(){
        Response response = GetAllProductsAPI.getProducts("desc", 10);
        response.prettyPrint();

        response.then()
                .spec(successResponseSpec);
    }
}
