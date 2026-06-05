package com.thinkgetit.backend.pojo;

public class TokenRefreshPayload {
    private String refreshToken;

    public TokenRefreshPayload(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}