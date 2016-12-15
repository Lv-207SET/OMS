package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import org.openqa.selenium.WebDriver;

public class CreateNewUserPage extends AUserDataPage {

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    //set data
    public CreateNewUserPage setLoginInput(String login) {
        getLoginInput().clear();
        getLoginInput().sendKeys(login);
        return this;
    }

    public CreateNewUserPage setFirstNameInput(String firstName) {
        super.setFirstNameInput(firstName);
        return this;
    }

    public CreateNewUserPage setLastNameInput(String lastName) {
        super.setLastNameInput(lastName);
        return this;
    }

    public CreateNewUserPage setPasswordInput(String password) {
        super.setPasswordInput(password);
        return this;
    }

    public CreateNewUserPage setConfirmPasswordInput(String confirmPassword) {
        super.setConfirmPasswordInput(confirmPassword);
        return this;
    }

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

}
