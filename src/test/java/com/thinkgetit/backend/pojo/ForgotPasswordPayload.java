package com.thinkgetit.backend.pojo;

public class ForgotPasswordPayload {
    private String email;

    public ForgotPasswordPayload(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}