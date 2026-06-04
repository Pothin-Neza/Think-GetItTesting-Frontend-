package com.thinkgetit.backend.pojo;

public class ResetPasswordPayload {
    private String newPassword;

    public ResetPasswordPayload(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}