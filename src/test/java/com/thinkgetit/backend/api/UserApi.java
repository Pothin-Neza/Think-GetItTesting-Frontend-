package com.thinkgetit.backend.api;

import com.thinkgetit.backend.pojo.UpdateProfilePayload;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class UserApi extends BaseApi {

    public static Response updateProfile(String token, String firstName, String lastName, String phone) {
        UpdateProfilePayload payload = new UpdateProfilePayload(firstName, lastName, phone);

        return getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.UPDATE_PROFILE);
    }

    public static Response uploadAvatar(String token, File imageFile) {
        return getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                // RestAssured automatically sets the Content-Type to multipart/form-data here
                .multiPart("avatar", imageFile) // "avatar" is the key name expected by the backend
                .when()
                .post(Routes.UPLOAD_AVATAR);
    }
}