package com.thinkgetit.backend.testCases.Authentication;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.Utilities.Utils;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ForgotPasswordAPITest extends BaseTest {

    @Test
    public void verifySystemAcceptsForgotPasswordRequestForValidUser() {
        String uniqueEmail = Utils.generateUniqueEmail("forgot");
        String defaultPassword = Utils.generateSecurePassword();

        Response regResponse = AuthApi.registerUser("Dave", "Chappelle", uniqueEmail, defaultPassword);
        regResponse.then().statusCode(201);

        Response forgotResponse = AuthApi.requestPasswordReset(uniqueEmail);

        forgotResponse.prettyPrint();

        forgotResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", notNullValue());
    }
}