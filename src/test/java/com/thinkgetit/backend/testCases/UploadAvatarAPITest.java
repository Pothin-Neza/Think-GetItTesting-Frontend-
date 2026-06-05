package com.thinkgetit.backend.testCases;

import com.thinkgetit.backend.api.AuthApi;
import com.thinkgetit.backend.api.UserApi;
import com.thinkgetit.backend.base.BaseTest;
import io.restassured.response.Response;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static org.hamcrest.Matchers.*;

public class UploadAvatarAPITest extends BaseTest {

    @Test
    public void verifyUserCanSuccessfullyUploadAvatarImage() throws IOException {
        String uniqueEmail = "avatar_" + System.currentTimeMillis() + "@othin.com";
        String password = "SecurePassword123!";

        AuthApi.registerUser("Tony", "Stark", uniqueEmail, password).then().statusCode(201);
        String accessToken = AuthApi.loginUser(uniqueEmail, password).jsonPath().getString("data.token");

        File tempImageFile = File.createTempFile("mock_avatar", ".png");
        Files.write(tempImageFile.toPath(), new byte[]{1, 2, 3, 4}); // Write fake dummy image bytes
        tempImageFile.deleteOnExit();

        Response uploadResponse = UserApi.uploadAvatar(accessToken, tempImageFile);

        uploadResponse.prettyPrint();

        uploadResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", equalTo("Avatar updated"))
                .body("data.id", notNullValue());
    }
}