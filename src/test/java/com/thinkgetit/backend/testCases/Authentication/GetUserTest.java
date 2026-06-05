package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class GetUserTest extends BaseTest {

    @Test
    public void verifyAuthenticatedUserCanFetchOwnProfileDetails() {
        String uniqueEmail = "profile_" + System.currentTimeMillis() + "@othin.com";

        Response regResponse = AuthApi.registerUser("Alex", "Jones", uniqueEmail, "SecurePass123!");
        regResponse.then().statusCode(201);

        String jwtToken = regResponse.jsonPath().getString("data.token");

        Response profileResponse = AuthApi.getCurrentUser(jwtToken);
        profileResponse.prettyPrint();

        profileResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("data.user.email", equalTo(uniqueEmail))
                .body("data.user.firstName", equalTo("Alex"))
                .body("data.user.lastName", equalTo("Jones"));
    }
}