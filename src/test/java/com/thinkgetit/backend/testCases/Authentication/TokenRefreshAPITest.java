package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class TokenRefreshAPITest extends BaseTest {

    @Test
    public void verifyUserCanRefreshSessionUsingValidRefreshToken() {
        String uniqueEmail = "refresh_" + System.currentTimeMillis() + "@othin.com";

        Response regResponse = AuthApi.registerUser("Jane", "Doe", uniqueEmail, "SecurePass123!");
        regResponse.then().statusCode(201);

        String localRefreshToken = regResponse.jsonPath().getString("data.refreshToken");

        Response refreshResponse = AuthApi.refreshSession(localRefreshToken);

        refreshResponse.prettyPrint();

        refreshResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("data.token", notNullValue()); // Confirms a fresh access token was minted!
    }
}