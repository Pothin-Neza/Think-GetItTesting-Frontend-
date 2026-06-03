package com.thinkgetit.backend.routes;

public class Routes {

    public static final String BASE_URL = "https://think-and-get-it-production.up.railway.app/api/v1";

    public static final String GET_TRENDING = "/products/trending";
    public static final String GET_PRODUCTS = "/products";
    public static final String Register = "/auth/register";
    public static final String VERIFY_EMAIL = "/auth/verify-email/{token}"; // {token} is a path param
    public static final String GET_ME = "/auth/me";
    public static final String LOGIN = "/auth/login";
//    public static final String GET_FLASH_SALES = "/products/flash-sale";
//    public static final String GET_CATEGORIES = "/categories";
}
