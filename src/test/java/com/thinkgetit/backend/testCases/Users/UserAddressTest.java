package com.thinkgetit.backend.testCases.Users;

import com.thinkgetit.backend.base.BaseTest;
import com.thinkgetit.backend.api.UserApi;
import com.thinkgetit.backend.pojo.AddressPayload;
import com.thinkgetit.backend.Utilities.Utils;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class UserAddressTest extends BaseTest {

    @Test
    public void testUserCanAddAndRetrieveAddress() {
        String dynamicStreet = Utils.generateRandomStreet();
        String dynamicPostalCode = Utils.generateRandomPostalCode();
        String dynamicPhone = Utils.generateRandomPhone();

        AddressPayload payload = new AddressPayload(
                "Pothin",
                "Neza",
                dynamicPhone,
                dynamicStreet,
                "Austin",
                "Texas",
                dynamicPostalCode,
                "Singapore"
        );

        // Add the address

        Response postResponse = UserApi.addAddress(payload, authToken);
        postResponse.prettyPrint();

        postResponse.then()
                .statusCode(201)
                .body("success", is(true));

        // Get the address

        Response getResponse = UserApi.getUserAddresses(authToken);
        getResponse.prettyPrint();

        getResponse.then()
                .statusCode(200)
                .body("success", is(true))
                .body("data", notNullValue());
    }
}