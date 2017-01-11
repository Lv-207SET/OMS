package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.locators.AUserDataPageLocators;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * This page represents PageObject for Create New User Page
 */
public class CreateNewUserPage extends AUserDataPage {

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    //set data
    @Step("Set Login Input")
    public CreateNewUserPage setLoginInput(String login) {
        getLoginInput().clear();
        getLoginInput().sendKeys(login);
        getFirstNameInput().sendKeys();
        return this;
    }

    @Step("Set FirstName Input")
    public CreateNewUserPage setFirstNameInput(String firstName) {
        super.setFirstNameInput(firstName);
        return this;
    }

    @Step("Set LastName Input")
    public CreateNewUserPage setLastNameInput(String lastName) {
        super.setLastNameInput(lastName);
        return this;
    }

    @Step("Set Password Input")
    public CreateNewUserPage setPasswordInput(String password) {
        super.setPasswordInput(password);
        return this;
    }

    @Step("Set Confirm Password Input")
    public CreateNewUserPage setConfirmPasswordInput(String confirmPassword) {
        super.setConfirmPasswordInput(confirmPassword);
        return this;
    }

    @Step("Set Email Input")
    public CreateNewUserPage setEmailInput(String email) {
        super.setEmailInput(email);
        return this;
    }

    public CreateNewUserPage setSelectRegion(Region region) {
        super.setSelectRegion(region);
        return this;
    }

    public CreateNewUserPage setSelectRole(Role roleId) {
        super.setSelectRole(roleId);
        return this;
    }

    public CreateNewUserPage clearLoginInput() {
        getLoginInput().clear();
        return this;
    }

    public CreateNewUserPage clearFirstNameInput() {
        super.clearFirstNameInput();
        return this;
    }

    public CreateNewUserPage clearLastNameInput() {
        super.clearLastNameInput();
        return this;
    }

    public CreateNewUserPage clearPasswordInput() {
        super.clearPasswordInput();
        return this;
    }

    public CreateNewUserPage clearConfirmPasswordInput() {
        super.clearConfirmPasswordInput();
        return this;
    }

    public CreateNewUserPage clearEmailInput() {
        super.clearEmailInput();
        return this;
    }

    @Step("Click Create Button")
    public CreateNewUserPage clickCreateButton() {
        super.clickCreateButton();
        return this;
    }

    public CreateNewUserPage clickCancelButton() {
        super.clickCancelButton();
        return this;
    }

    // business logic
    public CreateNewUserPage setLoginData(IUser user) {
        setLoginInput(user.getLoginname());
        super.setLoginData(user);
        return this;
    }

    public AdministrationPage successCreateNewUser(IUser validUser) {
        setLoginData(validUser);
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage unsuccessCreateNewUser(IUser invalidUser) {
        setLoginData(invalidUser);
        clickCreateButton();
        return this;
    }


    public AdministrationPage cancelCreateNewUser(IUser someUser) {
        setLoginData(someUser);
        clickCancelButton();
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage acceptAlert() {
        super.acceptAlert();
        return this;
    }

    @Override
    public CreateNewUserPage waitForLoad() {
        super.waitForLoad();
        return this;
    }

    public CreateNewUserPage waitForEmailErrorToDisappear() {
        if (waitForElemToDisappear(AUserDataPageLocators.ERROR_EMAIL.by)) {
            System.out.println("Email error disappeared");
            return this;
        } else {
            throw new RuntimeException("Waiting for error to disappear failed!");
        }
    }

}
