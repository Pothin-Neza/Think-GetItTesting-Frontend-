package com.thinkgetit.frontend;

import com.project.config.AppConfig;
import com.project.pages.AddToCartPage;
import com.project.pages.CheckoutPage;
import com.project.pages.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest{

    @Test
    public void verifyUserCanCheckoutSuccessfully() {

        page.navigate(AppConfig.BASE_URL);
        LoginPage loginPage = new LoginPage(page);
        AddToCartPage cartPage = new AddToCartPage(page);
        CheckoutPage checkoutPage = new CheckoutPage(page);

        loginPage.clickSignIn();
        loginPage.login(AppConfig.Email, AppConfig.PASSWORD);

        cartPage.clickProduct("Cargo Utility Shorts");
        cartPage.selectColor("Black");
        cartPage.clickAddToCart();


        checkoutPage.clickCheckoutButton();
        checkoutPage.clickAddNewAddressButton();
        checkoutPage.fillAddressForm("John", "Smith", "123 Main St", "New York", "NY", "10001", "123-456-7890", "00000");
        checkoutPage.clickSaveAddressButton();
        page.waitForTimeout(1500);


    }
}
