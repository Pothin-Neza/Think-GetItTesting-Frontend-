package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class ResetPasswordAPITest extends BaseTest {

    @Test
    public void verifySystemRejectsPasswordResetWithInvalidToken() {
        String fakeResetToken = "reset-token-0000000";
        String freshPassword = "NewPassword000!";

        Response resetResponse = AuthApi.resetPassword(fakeResetToken, freshPassword);

        resetResponse.prettyPrint();

        resetResponse.then()
                .statusCode(400)
                .body("success", is(false))
                .body("message", equalTo("Invalid or expired reset token"));
    }
}