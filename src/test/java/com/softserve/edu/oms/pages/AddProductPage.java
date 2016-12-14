package com.softserve.edu.oms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage extends ABasePage {

    private final static String CREATING_PRODUCT_LABEL_CSS = "#edit h3";
    private final static String PRODUCT_NAME_INPUT_ID = "name";
    private final static String PRODUCT_DESCRIPTION_TEXTAREA_ID = "description";
    private final static String PRODUCT_PRICE_INPUT_ID = "price";
    private final static String OK_BUTTON_CSS = "[value='OK']";
    private final static String CANCEL_BUTTON_CSS= "[value='Cancel']";
    private final static String ITEM_MANAGEMENT_TAB_CSS = "#nav .cur a";
    private final static String PRODUCT_NAME_ERROR_MESSAGE_ID = "productName.errors";
    private final static String PRODUCT_PRICE_ERROR_MESSAGE_ID = "productPrice.errors";

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    // get Data

    public WebElement getCreatingNewProductLabel() {
        return driver.findElement(By.cssSelector(CREATING_PRODUCT_LABEL_CSS));
    }

    public WebElement getProductNameInput() {
        return driver.findElement(By.id(PRODUCT_NAME_INPUT_ID));
    }

    public WebElement getProductDescriptionTextarea() {
        return driver.findElement(By.id(PRODUCT_DESCRIPTION_TEXTAREA_ID));
    }

    public WebElement getProductPriceInput() {
        return driver.findElement(By.id(PRODUCT_PRICE_INPUT_ID));
    }

    public WebElement getOkButton() {
        return driver.findElement(By.cssSelector(OK_BUTTON_CSS));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector(CANCEL_BUTTON_CSS));
    }

    public WebElement getItemManagementTab() {
        return driver.findElement(By.cssSelector(ITEM_MANAGEMENT_TAB_CSS));
    }

    public WebElement getProductNameErrorMessage() {
        return driver.findElement(By.id(PRODUCT_NAME_ERROR_MESSAGE_ID));
    }

    public WebElement getProductPriceErrorMessage() {
        return driver.findElement(By.id(PRODUCT_PRICE_ERROR_MESSAGE_ID));
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
