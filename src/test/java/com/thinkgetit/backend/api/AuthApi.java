
package com.thinkgetit.backend.api;

import com.thinkgetit.backend.pojo.LoginPayload;
import com.thinkgetit.backend.pojo.RegisterPayload;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthApi extends BaseApi {

    public static Response registerUser(String firstName, String lastName, String email, String password) {
        RegisterPayload payload = new RegisterPayload(firstName, lastName, email, password);

        return getDefaultRequest()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.Register);

    }

    public static Response verifyEmail(String verificationToken) {
        return getDefaultRequest()
                .pathParam("token", verificationToken) // Matches the {token} in the route URL
                .when()
                .get(Routes.VERIFY_EMAIL);
    }


    public static Response getCurrentUser(String jwtToken) {
        return getDefaultRequest()
                .header("Authorization", "Bearer " + jwtToken) // Attaches security clearance
                .when()
                .get(Routes.GET_ME);
    }

    public static Response loginUser(String email, String password) {
        LoginPayload payload = new LoginPayload(email, password);

        return getDefaultRequest()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.LOGIN);
    }
}