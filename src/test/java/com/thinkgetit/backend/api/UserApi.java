package com.thinkgetit.backend.api;

import com.thinkgetit.backend.pojo.AddressPayload;
import com.thinkgetit.backend.pojo.ChangePasswordPayload;
import com.thinkgetit.backend.pojo.UpdateProfilePayload;
import com.thinkgetit.backend.routes.Routes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static com.thinkgetit.backend.routes.Routes.ADDRESSES_ROUTE;

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
                .multiPart("avatar", imageFile)
                .when()
                .post(Routes.UPLOAD_AVATAR);
    }

    public static  Response changePassword(String currentPassword, String newPassword, String token) {
        ChangePasswordPayload payload = new ChangePasswordPayload(currentPassword, newPassword);

        return getDefaultRequest()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(payload)
                .when()
                .put(Routes.CHANGE_PASSWORD);
    }

    public static Response addAddress(AddressPayload payload, String jwtToken) {
        return getDefaultRequest()
                .header("Authorization", "Bearer " + jwtToken)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(ADDRESSES_ROUTE);
    }

    public static Response getUserAddresses(String jwtToken) {
        return getDefaultRequest()
                .header("Authorization", "Bearer " + jwtToken)
                .when()
                .get(ADDRESSES_ROUTE);
    }
}