package com.thinkgetit.backend.testCases.Users;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.api.UserApi;
import com.thinkgetit.backend.Utilities.Utils;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void testUserCanSuccessfullyChangePassword() {
        String newPassword = Utils.generateSecurePassword();


        Response response = UserApi.changePassword(
                currentPassword,
                newPassword,
                authToken
        );

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .log().ifValidationFails()
                .body("message", containsString("Password changed"));
    }
}