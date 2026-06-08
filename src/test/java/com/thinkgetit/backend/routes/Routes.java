package com.thinkgetit.backend.routes;

public class Routes {

    public static final String BASE_URL = "https://think-and-get-it-production.up.railway.app/api/v1";

    public static final String GET_TRENDING = "/products/trending";
    public static final String GET_PRODUCTS = "/products";
    public static final String Register = "/auth/register";
    public static final String VERIFY_EMAIL = "/auth/verify-email/{token}"; // {token} is a path param
    public static final String GET_ME = "/auth/me";
    public static final String LOGIN = "/auth/login";
    public static final String REFRESH_TOKEN = "/auth/refresh";
    public static final String FORGOT_PASSWORD = "/auth/forgot-password";
    public static final String RESET_PASSWORD = "/auth/reset-password/{token}";
    public static final String UPDATE_PROFILE = "/users/profile";
    public static final String UPLOAD_AVATAR = "/users/avatar";
    public static final String CHANGE_PASSWORD = "/users/change-password";
    public static final String ADDRESSES_ROUTE = "/users/addresses";


}
