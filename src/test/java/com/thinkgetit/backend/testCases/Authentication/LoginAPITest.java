package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class LoginAPITest extends BaseTest {

    @Test
    public void verifyUserCanLoginSuccessfullyWithValidCredentials() {
        String uniqueEmail = "login_" + System.currentTimeMillis() + "@othin.com";
        String password = "SecurePassword123!";

        Response regResponse = AuthApi.registerUser("Tom", "Jerry", uniqueEmail, password);
        regResponse.then().statusCode(201);

        Response loginResponse = AuthApi.loginUser(uniqueEmail, password);

        loginResponse.prettyPrint();

        loginResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", equalTo("Login successful"))
                .body("data.token", notNullValue())
                .body("data.user.email", equalTo(uniqueEmail));
    }
}