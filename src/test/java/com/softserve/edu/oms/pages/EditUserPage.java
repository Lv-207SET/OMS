package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.IUser;
import com.softserve.edu.oms.enums.Region;
import com.softserve.edu.oms.enums.Role;
import com.softserve.edu.oms.enums.SelectRegionDropdownList;
import com.softserve.edu.oms.enums.SelectRoleDropdownList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditUserPage  extends AUserDataPage {
    public EditUserPage (WebDriver driver) {
        super(driver);
    }

    public EditUserPage setLoginInput(String login) {
        getLoginInput().clear();
        getLoginInput().sendKeys(login);
        return this;
    }

    public EditUserPage clearLoginInput() {
        getLoginInput().clear();
        return this;
    }
    // business logic
    public EditUserPage setLoginData(IUser user) {
        setFirstNameInput(user.getFirstname());
        setLastNameInput(user.getLastname());
        setPasswordInput(user.getPassword());
        setConfirmPasswordInput(user.getPassword());
        setEmailInput(user.getEmail());
        setSelectRegion(Region.getRegion(user.getRegion()));
        setSelectRole(Role.valueOf(user.getRole().toUpperCase()));
        return this;
    }

    public AdministrationPage successEditUser(IUser validUser){
        setLoginData(validUser);
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public AdministrationPage successEditUser(){
        clickCreateButton();
        return new AdministrationPage(driver);
    }

    public AdministrationPage cancelEditUser(IUser someUser) {
        setLoginData(someUser);
        clickCancelButton();
        return new AdministrationPage(driver);
    }

}

