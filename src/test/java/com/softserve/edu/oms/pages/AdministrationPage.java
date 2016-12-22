package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.enums.ConditionFilterDropdownList;
import com.softserve.edu.oms.enums.FieldFilterDropdownList;
import com.softserve.edu.oms.enums.SortingOrder;
import com.softserve.edu.oms.enums.UsersPerPage;
import com.softserve.edu.oms.locators.AdministrationPageLocators;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.NoSuchElementException;

public class AdministrationPage extends AAdminReportPage {

    private FieldFilterDropdownList fieldFilterDropdownList;
    private SortingOrder sortingOrderEnum;
    private UsersPerPage usersPerPage;

	public AdministrationPage(WebDriver driver) {
		super(driver);
	}

    //  User as role an "Administrator" goes from tab "Administration" to
	//  "Create New User" page by using this method
    @Step("User as role an Administrator goes from tab Administration to Create New User page")
	public CreateNewUserPage gotoCreateNewUserPage() {
		driver.findElement(AdministrationPageLocators.GO_TO_CREATE_NEW_USER_PAGE_CSS.by).click();
		return new CreateNewUserPage(this.driver);
	}

	// Delete user by login. Administrator set Fields filter on User Name,
	// set condition filter on equals input login of desired user who should be deleted into
	// search text field and click search button
	public AdministrationPage deleteUserByLogin(final String login, boolean deleteUserOrNot) {
        selectField(FieldFilterDropdownList.LOGIN);
        selectCondition(ConditionFilterDropdownList.EQUALS);
        search(login);

		try {
			driver.findElement(AdministrationPageLocators.DELETE_LINK_TEXT.by).click();
			if (deleteUserOrNot) {
				driver.switchTo().alert().accept();
			} else {
				driver.switchTo().alert().dismiss();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No user with such login found");
		}
		return this;
	}

    @Override
    public AdministrationPage sortByFirstNameASC(){
        super.sortByFirstNameASC();
        return this;
    }

    @Override
    public AdministrationPage sortByFirstNameDESC(){
        super.sortByFirstNameDESC();
        return this;
    }

    @Override
    public AdministrationPage sortByLastNameASC(){
        super.sortByLastNameASC();
        return this;
    }

    @Override
    public AdministrationPage sortByLastNameDESC(){
        super.sortByLastNameDESC();
        return this;
    }

    @Override
    public AdministrationPage sortByLoginASC(){
        super.sortByLoginASC();
        return this;
    }

    @Override
    public AdministrationPage sortByLoginDESC(){
        super.sortByLoginDESC();
        return this;
    }

    @Override
    public AdministrationPage sortByRoleASC(){
        super.sortByRoleASC();
        return this;
    }

    @Override
    public AdministrationPage sortByRoleDESC(){
        super.sortByRoleDESC();
        return this;
    }

    @Override
    public AdministrationPage sortByRegionASC(){
        super.sortByRegionASC();
        return this;
    }

    @Override
    public AAdminReportPage sortByRegionDESC(){
        super.sortByRegionDESC();
        return this;
    }

    @Override
    public AdministrationPage waitForLoad() {
        super.waitForLoad();
        return this;
    }

	//   Change user quantity per page by click "Show 10 items" or "Show 5 items"
	public AdministrationPage changeQuantityOfUsersPerPage(){
		getShowItemsLink().click();
		return this;
	}

	public boolean showItemsLinkIsDisplayed () {
		return this.getShowItemsLink().isDisplayed();
	}


	//  Find user and return EditUserPage for user editing
	public EditUserPage editUserByLogin(String login){
        selectField(FieldFilterDropdownList.LOGIN);
        selectCondition(ConditionFilterDropdownList.EQUALS);
        search(login);

		driver.findElement(AdministrationPageLocators.EDIT_USER_LINK_TEXT.by).click();
		return new EditUserPage(driver);
	}

    @Step("getQuantityOfUsersPerPage")
	public int getQuantityOfUsersPerPage (){
		return getUsersFromCurrentPage().size();
	}


	//Set default search
	public AdministrationPage setDefaultFilterConditions(){
        selectField(FieldFilterDropdownList.LOGIN);
        selectCondition(ConditionFilterDropdownList.EQUALS);
        clickSearchButton();
		return this;
	}

	public CreateReportPage goToCreateReportPage() {
		driver.findElement(AdministrationPageLocators.CREATE_REPORT_CSS_SELECTOR.by).click();
		return new CreateReportPage(this.driver);
	}

}


