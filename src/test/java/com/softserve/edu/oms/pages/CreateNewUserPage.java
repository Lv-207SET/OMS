package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static com.softserve.edu.oms.locators.CreateNewUserPageLocators.*;

public class CreateNewUserPage extends AUserDataPage {

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewUserPage setLoginInput(String login) {
        getLoginInput().clear();
        getLoginInput().sendKeys(login);
        return this;
    }

    public CreateNewUserPage clearLoginInput() {
        getLoginInput().clear();
        return this;
    }
    // business logic
    public CreateNewUserPage setLoginData(IUser user) {
        setLoginInput(user.getLoginname());
        setFirstNameInput(user.getFirstname());
        setLastNameInput(user.getLastname());
        setPasswordInput(user.getPassword());
        setConfirmPasswordInput(user.getPassword());
        setEmailInput(user.getEmail());
        setSelectRegion(Region.getRegion(user.getRegion()));
        setSelectRole(Role.valueOf(user.getRole().toUpperCase()));
        return this;
    }

    public AdministrationPage successCreateNewUser(IUser validUser){
        setLoginData(validUser);
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public CreateNewUserPage unsuccessCreateNewUser(IUser invalidUser){
        setLoginData(invalidUser);
        clickCreateButton();
        return this;
    }

    // ???
    public AdministrationPage successCreateNewUser(){
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public AdministrationPage cancelCreateNewUser(IUser someUser) {
        setLoginData(someUser);
        clickCancelButton();
        return new AdministrationPage(driver);
    }
    public CreateNewUserPage acceptAlert() {
        driver
                .switchTo()
                .alert()
                .accept();
        return this;
    }

    @Override
    public CreateNewUserPage waitForLoad() {
        super.waitForLoad();
        return this;
    }

}
