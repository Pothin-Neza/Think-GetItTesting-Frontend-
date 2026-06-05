package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ForgotPasswordAPITest extends BaseTest {

    @Test
    public void verifySystemAcceptsForgotPasswordRequestForValidUser() {
        String uniqueEmail = "forgot_" + System.currentTimeMillis() + "@othin.com";

        Response regResponse = AuthApi.registerUser("Dave", "Chappelle", uniqueEmail, "SecurePass123!");
        regResponse.then().statusCode(201);

        Response forgotResponse = AuthApi.requestPasswordReset(uniqueEmail);

        forgotResponse.prettyPrint();

        forgotResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", notNullValue());
    }
}