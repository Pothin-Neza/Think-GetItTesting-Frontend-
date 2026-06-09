package com.thinkgetit.backend.testCases.Users;

import com.thinkgetit.backend.Utilities.Utils;
import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.api.UserApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class UpdateProfileAPITest extends BaseTest {

    @Test
    public void verifyUserCanSuccessfullyUpdateTheirProfileDetails() {
        String uniqueEmail = Utils.generateUniqueEmail("johnny.bravo");
        String initialPassword = Utils.generateSecurePassword();

        AuthApi.registerUser("Johnny", "Bravo", uniqueEmail, initialPassword).then().statusCode(201);

        Response loginResponse = AuthApi.loginUser(uniqueEmail, initialPassword);
        String accessToken = loginResponse.jsonPath().getString("data.token");

        String updatedFirstName = "John";
        String updatedLastName = "Wick";
        String updatedPhone = "0789898989";

        Response updateResponse = UserApi.updateProfile(accessToken, updatedFirstName, updatedLastName, updatedPhone);

        updateResponse.prettyPrint();

        updateResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("data.firstName", equalTo(updatedFirstName))
                .body("data.lastName", equalTo(updatedLastName))
                .body("data.phone", equalTo(updatedPhone));
    }
}