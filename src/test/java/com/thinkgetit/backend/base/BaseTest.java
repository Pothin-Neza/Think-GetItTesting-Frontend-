package com.thinkgetit.backend.base;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.routes.Routes;
import com.thinkgetit.backend.Utilities.Utils; // Import your Utils class
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Before;

public class BaseTest {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification successResponseSpec;

    protected String authToken;
    protected String currentPassword;
    protected String currentEmail;

    @BeforeClass
    public static void setupSpecifications() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Routes.BASE_URL)
                .addHeader("Accept", "application/json")
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Before
    public void loginAndAuthenticateUser() {
        this.currentEmail = Utils.generateUniqueEmail("testuser");
        this.currentPassword = Utils.generateSecurePassword();

        Response regResponse = AuthApi.registerUser("QA", "Engineer", currentEmail, currentPassword);
        regResponse.prettyPrint();

        Response loginResponse = AuthApi.loginUser(currentEmail, currentPassword);
        loginResponse.prettyPrint();

        this.authToken = loginResponse.jsonPath().getString("data.token");
        System.out.println("EXTRACTED TOKEN: " + this.authToken);
    }
}