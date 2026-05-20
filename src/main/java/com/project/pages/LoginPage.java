package com.project.pages;

import com.microsoft.playwright.Page;

import static com.project.config.AppConfig.Email;
import static com.project.config.AppConfig.PASSWORD;


public class LoginPage {

    private final Page page;


    private final String signInButton = "//*[@id=\"root\"]/div[1]/nav/div[2]/a[1]";
    private final String EmailInput = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div[1]/input";
    private final String passwordInput = "//*[@id=\"root\"]/div[1]/div[2]/div/form/div[2]/div[2]/input";
    private final String loginButton = "//*[@id=\"root\"]/div[1]/div[2]/div/form/button";
    private final String logoutLucide_userIcon = "//*[@id=\"root\"]/div[1]/header/div/div/div/div/button";
    private final String logoutButton = "//*[@id=\"root\"]/div[1]/header/div/div/div/div/div/button";

    public LoginPage (Page page) {
        this.page = page;
    }

    public void clickSignIn() {
        page.locator(signInButton).click();
    }

    public void login(String email, String password){
        page.locator(EmailInput).fill(Email);
        page.locator(passwordInput).fill(PASSWORD);
        page.locator(loginButton).click();
    }

    public void logout(){
        page.locator(logoutLucide_userIcon).hover();
        page.locator(logoutButton).click();
    }
}
