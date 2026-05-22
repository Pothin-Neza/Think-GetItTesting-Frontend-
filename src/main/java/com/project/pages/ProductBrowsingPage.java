package com.project.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import java.util.ArrayList;
import java.util.List;

public class ProductBrowsingPage {

    private final Page page;
    private final String viewAllButton = "//*[@id='root']/div[1]/main/div/section[3]/div[1]/a";
    private final String productSortDropdown = "//*[@id=\"root\"]/div[1]/main/div/div[1]/div[2]/div/select";
    private final String productPrices = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div/div[1]/a[1]/div[2]/div[2]/span[1]";

    public ProductBrowsingPage(Page page) {
        this.page = page;
    }

    public void clickViewAll() {
        page.locator(viewAllButton).click();
    }

    public void selectSortOption(String valueCode) {
        page.locator(productSortDropdown).selectOption(valueCode);
        page.waitForTimeout(2000);
    }

    public List<Double> getAllProductPrices() {
        List<Double> prices = new ArrayList<>();
        Locator priceElements = page.locator(productPrices);
        int totalProducts = priceElements.count();

        for (int i = 0; i < totalProducts; i++) {
            String rawText = priceElements.nth(i).innerText();
            String cleanedText = rawText.replace("$", "").trim();
            prices.add(Double.parseDouble(cleanedText));
        }

        return prices;
    }
}