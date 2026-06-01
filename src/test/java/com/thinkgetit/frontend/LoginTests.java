package com.thinkgetit.frontend;

import com.project.config.AppConfig;
import com.project.pages.LoginPage;
import org.junit.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    @Test
    public void testUserCanLogin(){
        LoginPage loginPage = new LoginPage(page);

        page.navigate(AppConfig.BASE_URL);
        loginPage.clickSignIn();
        loginPage.login(AppConfig.Email, AppConfig.PASSWORD);

        assertThat(page).hasURL(Pattern.compile("home"));
    }

    // login with Empty fields

    @Test
    public void testLoginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(page);

        page.navigate(AppConfig.BASE_URL);
        loginPage.clickSignIn();

        loginPage.login("", "");

        assertThat(page).not().hasURL(Pattern.compile("home"));
    }

    //logout test
    @Test
    public void testUserCanLogout() {
        LoginPage loginPage = new LoginPage(page);

        page.navigate(AppConfig.BASE_URL);
        loginPage.clickSignIn();
        loginPage.login(AppConfig.Email, AppConfig.PASSWORD);
        loginPage.logout();

        assertThat(page).hasURL(AppConfig.BASE_URL);
    }

}