package com.thinkgetit.backend.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 POJO representation of the registration request payload.
 */

public class RegisterPayload {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    private String email;
    private String password;

    public RegisterPayload(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}