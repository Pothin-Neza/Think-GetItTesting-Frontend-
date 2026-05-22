package com.thinkgetit.frontend;

import com.project.config.AppConfig;
import com.project.pages.LoginPage;
import com.project.pages.ProductBrowsingPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductSortTest extends BaseTest {

    @Before
    public void loginAndNavigateToProducts() {
        page.navigate(AppConfig.BASE_URL + AppConfig.LOGIN_PAGE);
        LoginPage loginPage = new LoginPage(page);
//        loginPage.clickSignIn();
        loginPage.login(AppConfig.Email, AppConfig.PASSWORD);

        page.waitForURL("**/home");
    }

    @Test
    public void verifyPriceSortingLowToHigh() {
        ProductBrowsingPage browsingPage = new ProductBrowsingPage(page);

        browsingPage.clickViewAll();
        browsingPage.selectSortOption("price_asc");

        List<Double> actualPrices = browsingPage.getAllProductPrices();
        List<Double> expectedSortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedSortedPrices);

        Assert.assertEquals("The products are not sorted from Low to High!", expectedSortedPrices, actualPrices);
        page.waitForTimeout(2000);
    }

    @Test
    public void verifyPriceSortingHighToLow() {
        ProductBrowsingPage browsingPage = new ProductBrowsingPage(page);

        browsingPage.clickViewAll();
        browsingPage.selectSortOption("price_desc");

        List<Double> actualPrices = browsingPage.getAllProductPrices();
        List<Double> expectedSortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedSortedPrices, Collections.reverseOrder());

        Assert.assertEquals("The products are not sorted from High to Low!", expectedSortedPrices, actualPrices);
        page.waitForTimeout(2000);

    }
}