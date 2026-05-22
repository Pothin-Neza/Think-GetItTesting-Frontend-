package com.thinkgetit.frontend;

import com.project.config.AppConfig;
import com.project.pages.AddToCartPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddToCartTests extends BaseTest {

    @Before
    public void loginAndGoToCatalog() {
        page.navigate(AppConfig.BASE_URL + AppConfig.homePage);
        String ShopNowButton = "//*[@id=\"root\"]/div[1]/main/div/section[1]/div[2]/div/div[2]/a[1]";
        String ElectronicsCategory = "//*[@id=\"root\"]/div[1]/main/div/div[2]/aside/div/div[2]/div[1]/div/button[4]";
        page.locator(ShopNowButton).click();
        page.locator(ElectronicsCategory).click();

    }

    @Test
    public void verifyUserCanAddCustomProductToCart() {
        AddToCartPage addToCartPage = new AddToCartPage(page);
        String productToTest = "Smart Wi-Fi Power Plug";

        addToCartPage.clickProduct(productToTest);


        addToCartPage.selectColor("Black");
        addToCartPage.clickAddToCart();
        addToCartPage.viewCart();

        Assert.assertTrue(
                "Expected product '" + productToTest + "' was not found inside the cart list!",
                addToCartPage.isProductInCartList(productToTest)
        );
        page.waitForTimeout(2000);
    }
}