package com.project.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    public final Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }
    public final String cartIcon = "//*[@id=\"root\"]/div[1]/header/div/div/div/button[2]/svg";
    public final String checkoutButton = "//*[@id=\"root\"]/div[1]/div[3]/div[3]/div[2]/a[2]";
    public final String addNewAddressButton = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div[1]/div/button[1]";
    public final String firstNameInput = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div[1]/div/form/div[1]/input[1]";
    public final String lastNameInput = "[input[placeholder='Last name']]";
    public final String phoneNumberInput = "[input[placeholder='Phone number']]";
    public final String StreetAddressInput = "[input[placeholder='Street address']]";
    public final String cityInput = "[input[placeholder='City']]";
    public final String stateInput = "[input[placeholder='State / Region']]";
    public final String countryInput = "[input[placeholder='Country']]";
    public final String postalCodeInput = "[input[placeholder='Postal code (Optional)']]";
    public final String saveAddressButton = "//*[@id=\"root\"]/div[1]/main/div/div[2]/div[1]/div/form/div[2]/button[1]";

    public  void clickCartIcon(){
        page.locator(cartIcon).click();
    }
    public void clickCheckoutButton(){
        page.locator(checkoutButton).click();
    }
    public void clickAddNewAddressButton() {
        page.locator(addNewAddressButton).click();
    }
    public void fillAddressForm(String firstName, String lastName, String phoneNumber, String streetAddress, String city, String state, String country, String postalCode) {
        page.locator(firstNameInput).fill(firstName);
        page.locator(lastNameInput).fill(lastName);
        page.locator(phoneNumberInput).fill(phoneNumber);
        page.locator(StreetAddressInput).fill(streetAddress);
        page.locator(cityInput).fill(city);
        page.locator(stateInput).fill(state);
        page.locator(countryInput).fill(country);
        page.locator(postalCodeInput).fill(postalCode);
    }
    public void clickSaveAddressButton() {
        page.locator(saveAddressButton).click();
    }

}
