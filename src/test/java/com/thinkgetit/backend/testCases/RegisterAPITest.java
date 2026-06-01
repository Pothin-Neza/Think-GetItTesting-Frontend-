package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.RegisterApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
// A test class to verify user registration functionality of the API.

public class RegisterAPITest extends BaseTest {

    @Test
    public void verifyUserCanRegisterSuccessfully() {
        String uniqueEmail = "tester_" + System.currentTimeMillis() + "@othin.com";

        Response response = RegisterApi.registerUser("John", "Doe", uniqueEmail, "SecurePassword123");

        System.out.println("\n SERVER RESPONSE PAYLOAD ");
        response.prettyPrint();

        response.then()
                .statusCode(201)
                .body("success", is(true))
                .body("data.user.id", notNullValue());

    }
}