package com.thinkgetit.frontend;

import com.project.config.AppConfig;
import com.project.pages.AddToCartPage;
import org.junit.Before;
import org.junit.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AddToCartTests extends BaseTest {

    @Before
    public void loginAndGoToCatalog() {
        page.navigate(AppConfig.BASE_URL + AppConfig.homePage);
        String viewAllButton = "//*[@id=\"root\"]/div[1]/main/div/section[3]/div[1]/a";
        String ElectronicsCategory = "//*[@id=\"root\"]/div[1]/main/div/div[2]/aside/div/div[2]/div[1]/div/button[4]";
        page.locator(viewAllButton).click();
        page.locator(ElectronicsCategory).click();

        page.locator("//*[@id='root']/div[1]/main/div/section[3]/div[1]/a").waitFor();
    }

    @Test
    public void verifyUserCanAddCustomProductToCart() {
        AddToCartPage addToCartPage = new AddToCartPage(page);
        String productToTest = "Smart Wi-Fi Power Plug";

        // Now passing the parameter dynamically instead of using a hardcoded method slot
        addToCartPage.clickProduct(productToTest);

//        addToCartPage.selectSize("L");
        addToCartPage.selectColor("Black");
        addToCartPage.clickAddToCart();
        addToCartPage.viewCart();

        // Dynamic Verification Assertion
        org.junit.Assert.assertTrue(
                "Expected product '" + productToTest + "' was not found inside the cart list!",
                addToCartPage.isProductInCartList(productToTest)
        );
    }
}