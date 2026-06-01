package com.thinkgetit.backend.api;

import com.thinkgetit.backend.pojo.RegisterPayload;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RegisterApi extends BaseApi {

    public static Response registerUser(String firstName, String lastName, String email, String password) {
        RegisterPayload payload = new RegisterPayload(firstName, lastName, email, password);

        return getDefaultRequest()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.Register);

    }
}