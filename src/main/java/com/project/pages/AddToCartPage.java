package com.project.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddToCartPage {

    private final Page page;

    public AddToCartPage(Page page) {
        this.page = page;
    }

    public void clickProduct(String productName) {
        String productHeadingSelector = "h3:has-text('" + productName + "')";
        page.locator(productHeadingSelector).first().click();
    }

//    public void selectSize(String size) {
//        page.locator("button:has-text('" + size + "')").click();
//    }

    public void selectColor(String colorName) {
        String colorSelector = "button[title='" + colorName + "']";
        page.locator(colorSelector).click();
    }

    public void clickAddToCart(){
        String addToCartButton = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div[2]/div[7]/button[1]";
        page.locator(addToCartButton).click();
    }

    public void viewCart(){
        String viewCartButton = "a[href='/cart']";
        page.locator(viewCartButton).click();
    }

    public boolean isProductInCartList(String expectedProductName) {
        String cartItemTitlesSelector = "div.flex-1.min-w-0 a.font-body";

        Locator titles = page.locator(cartItemTitlesSelector);
        int count = titles.count();

        for (int i = 0; i < count; i++) {
            String actualName = titles.nth(i).innerText().trim();
            if (actualName.equalsIgnoreCase(expectedProductName)) {
                return true;
            }
        }
        return false;
    }
}