package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.locators.AddProductPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage extends ABasePage {

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    // get Data

    public WebElement getCreatingNewProductLabel() {
        return driver.findElement(AddProductPageLocators.CREATING_PRODUCT_LABEL_CSS.by);
    }

    public WebElement getProductNameInput() {
        return driver.findElement(AddProductPageLocators.PRODUCT_NAME_INPUT_ID.by);
    }

    public WebElement getProductDescriptionTextarea() {
        return driver.findElement(AddProductPageLocators.PRODUCT_DESCRIPTION_TEXTAREA_ID.by);
    }

    public WebElement getProductPriceInput() {
        return driver.findElement(AddProductPageLocators.PRODUCT_PRICE_INPUT_ID.by);
    }

    public WebElement getOkButton() {
        return driver.findElement(AddProductPageLocators.OK_BUTTON_CSS.by);
    }

    public WebElement getCancelButton() {
        return driver.findElement(AddProductPageLocators.CANCEL_BUTTON_CSS.by);
    }

    public WebElement getItemManagementTab() {
        return driver.findElement(AddProductPageLocators.ITEM_MANAGEMENT_TAB_CSS.by);
    }

    public WebElement getProductNameErrorMessage() {
        return driver.findElement(AddProductPageLocators.PRODUCT_NAME_ERROR_MESSAGE_ID.by);
    }

    public WebElement getProductPriceErrorMessage() {
        return driver.findElement(AddProductPageLocators.PRODUCT_PRICE_ERROR_MESSAGE_ID.by);
    }

    // functional

    public String getCreatingNewProductLabelText() {
        return getCreatingNewProductLabel().getText();
    }

    public String getProductNameInputText() {
        return getProductNameInput().getText();
    }

    public String getProductDescriptionTextareaText() {
        return getProductDescriptionTextarea().getText();
    }

    public String getProductPriceInputText() {
        return getProductPriceInput().getText();
    }

    public String getOkButtonText() {
        return getOkButton().getText().trim();
    }

    public String getCancelButtonText() {
        return getCancelButton().getText().trim();
    }

    public String getItemManagementTabText() {
        return getItemManagementTab().getText();
    }

    public String getProductNameErrorMessageText() {
        return getProductNameErrorMessage().getText();
    }

    public String getProductPriceErrorMessageText() {
        return getProductPriceErrorMessage().getText();
    }

    public double getProductPriceInputValue() {
        return Double.parseDouble(getProductPriceInputText());
    }

    // set Data

    public AddProductPage setProductName(String productNameValue) {
        getProductNameInput().clear();
        getProductNameInput().sendKeys(productNameValue);
        return this;
    }

    public AddProductPage setProductDescription(String productDescriptionValue) {
        getProductDescriptionTextarea().clear();
        getProductDescriptionTextarea().sendKeys(productDescriptionValue);
        return this;
    }

    public AddProductPage setProductPrice(double productPriceValue) {
        getProductPriceInput().clear();
        getProductPriceInput().sendKeys(String.valueOf(productPriceValue));
        return this;
    }

    public AddProductPage clearProductNameInput() {
        getProductNameInput().clear();
        return this;
    }

    public AddProductPage clearProductDescriptionTextarea() {
        getProductDescriptionTextarea().clear();
        return this;
    }

    public AddProductPage clearProductPriceInput() {
        getProductPriceInput().clear();
        return this;
    }

    public AddProductPage clickOkButton() {
        getOkButton().click();
        return this;
    }

    public AddProductPage clickCancelButton() {
        getCancelButton().click();
        return this;
    }

    // business logic

    public ItemManagementPage successCreateNewProduct(String productName, String description, double price) {
        setProductName(productName);
        setProductDescription(description);
        setProductPrice(price);
        clickOkButton();
        return new ItemManagementPage(driver);
    }

    public AddProductPage unsuccessCreateNewProduct(String productName, String description, double price) {
        setProductName(productName);
        setProductDescription(description);
        setProductPrice(price);
        clickOkButton();
        return this;
    }

    public ItemManagementPage createProductAndCancel(String productName, String description, double price) {
        setProductName(productName);
        setProductDescription(description);
        setProductPrice(price);
        clickCancelButton();
        return new ItemManagementPage(driver);
    }

    public ItemManagementPage goToItemManagementPage () {
        getItemManagementTab().click();
        return new ItemManagementPage(driver);
    }
}
