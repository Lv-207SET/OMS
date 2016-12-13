package com.softserve.edu.oms.pages;

import com.softserve.edu.oms.data.User;
import com.softserve.edu.oms.enums.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

public class AdministrationPage {

	// Fields
	private WebDriver driver;
	//

	public AdministrationPage(WebDriver driver) {
		this.driver = driver;
	}

	// PageObject

	// get Data


	public static final String SHOW_ITEMS_LINK_CSS = "#list p a";
	public static final String GO_TO_CREATE_NEW_USER_PAGE_CSS = "#list>a";
	public static final String SELECT_FIELD_FILTER_DROPDOWN_LIST_ID = "field";
	public static final String SELECT_CONDITION_FILTER_DROPDOWN_LIST_ID = "condition";
	public static final String SEARCH_INPUT = "searchField";
	public static final String SEARCH_BUTTON = "input[value='Search']";
	public static final String DELETE = "Delete";
	public static final String GET_USER_BY_LOGIN = "//tr[1]/td[1]";//???
	public static final String TABLE_BODY = "tbody";
	public static final String TR = "tr";
	public static final String TD = "td";
	public static final String FORWARD_BUTTON = "next";
	public static final String LAST_BUTTON = "last";
	public static final String PREVIOUS_BUTTON = "previous";
	public static final String FIRST_BUTTON = "first";
	public static final String USERS_FOUND = "usersFound";
	public static final String TOTAL_PAGE_NUMBER = "pageCount";
	public static final String CURRENT_PAGE_NUMBER = "pageNumber";
	public static final String LINK_EDIT_USER = "Edit";
	public final static String CREATE_REPORT_LINK_CSS = "#list h5 a";
	public static final String FIRST_NAME_LINK_CSS = "th:nth-child(1) a";
	public static final String LAST_NAME_LINK_CSS = "th:nth-child(2) a";
	public static final String LOGIN_LINK_CSS= "th:nth-child(3) a";
	public static final String ROLE_LINK_CSS = "th:nth-child(4) a";
	public static final String REGION_LINK_CSS = "th:nth-child(5) a";


	private FieldFilterDropdownList fieldFilterDropdownList;
	private SortingOrder sortingOrderEnum;
	private UsersPerPage usersPerPage;

//	public AdministrationPage(final WebDriver driver) {
//		super(driver);
//		sortingOrderEnum = null;
//		fieldFilterDropdownList = null;
//		usersPerPage = UsersPerPage.FIVE;
//	}

	//  User as role an "Administrator" goes from tab "Administration" to
	//  "Create New User" page by using this method
	public CreateNewUserPage goToCreateNewUserPage() {
		driver.findElement(By.cssSelector(GO_TO_CREATE_NEW_USER_PAGE_CSS)).click();
		return new CreateNewUserPage(this.driver);
	}

	//  Administrator select all fields in "Field Filter" dropdown list
	//  in "Search by" block on "Administration" tab
	public AdministrationPage selectFieldFilterDropdownList(final FieldFilterDropdownList fieldFilterDropdownList) {
		WebElement selectFieldFilterElement = driver.findElement(By.id(SELECT_FIELD_FILTER_DROPDOWN_LIST_ID));
		final Select selectDropdownList = new Select(selectFieldFilterElement);
		selectDropdownList.selectByVisibleText(fieldFilterDropdownList.getFieldName());
		return this;
	}

	//  Administrator select all fields in "Condition Filter" dropdown list
	//  in "Search by" block on "Administration" tab
	public AdministrationPage selectConditionFilterDropdownList(final ConditionFilterDropdownList conditionFilter) {
		WebElement selectConditionFilterElement = driver.findElement(By.id(SELECT_CONDITION_FILTER_DROPDOWN_LIST_ID));
		final Select selectConditionFilter = new Select(selectConditionFilterElement);
		selectConditionFilter.selectByVisibleText(conditionFilter.getNameOfConditionFilterField());
		return this;
	}

	//  Input text into text field for searching in "Search by" block
	public AdministrationPage inputIntoSearchField(String searchedString) {
		driver.findElement(By.id(SEARCH_INPUT)).click();
		driver.findElement(By.id(SEARCH_INPUT)).sendKeys(searchedString);
		return this;
	}

	// Clean search text field in "Search by" block
	public AdministrationPage clearSearchTextBox() {
		driver.findElement(By.id(SEARCH_INPUT)).click();
		driver.findElement(By.id(SEARCH_INPUT)).clear();
		return this;
	}

	//  Click "Search" button in "Search by" field
	public AdministrationPage clickSearchButton() {
		driver.findElement(By.cssSelector(SEARCH_BUTTON)).click();
		return this;
	}

	// Delete user by login. Administrator set Fields filter on User Name,
	// set condition filter on equals input login of desired user who should be deleted into
	// search text field and click search button
	public AdministrationPage deleteUserByLogin(final String login, boolean deleteUserOrNot) {
		this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
				.selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
				.inputIntoSearchField(login)
				.clickSearchButton();

		try {
			driver.findElement(By.linkText(DELETE)).click();
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

	//  Sort users by column head
	public AdministrationPage sortTableByColumn(final FieldFilterDropdownList fieldFilterDropdown,
												final SortingOrder sortingOrder){
		driver.findElement(By.partialLinkText(fieldFilterDropdown.getFieldName())).click();
		sortingOrderEnum = sortingOrder;
		fieldFilterDropdownList = fieldFilterDropdown;
		return this;
	}

	public WebElement getShowItemsLink (){
		return driver.findElement(By.cssSelector(SHOW_ITEMS_LINK_CSS));
	}

	public String getShowItemsLinkText (){
		return getShowItemsLink().getText();
	}

	//   Change user quantity per page by click "Show 10 items" or "Show 5 items"
	public AdministrationPage changeQuantityOfUsersPerPage(){
		getShowItemsLink().click();
		return this;
	}

	public boolean showItemsLinkIsDisplayed () {
		return this.getShowItemsLink().isDisplayed();
	}

	//   Find user by login and return as java object in purpose to compare it with
	//   data in database
	public User getUserByLoginAndTransferToJavaObject(String login) {
		this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
				.selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
				.inputIntoSearchField(login)
				.clickSearchButton();

		User user = new User();
		user.setFirstname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setLastname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setPassword(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setLoginname(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setEmail(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setRegion(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
		user.setRole(driver.findElement(By.xpath(GET_USER_BY_LOGIN)).getText());
				;
		return user;
	}

	//  Find user and return EditUserPage for user editing
	public EditUserPage editUserByLogin(String login){
		this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
				.selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
				.inputIntoSearchField(login)
				.clickSearchButton();
		driver.findElement(By.linkText(LINK_EDIT_USER)).click();
		return new EditUserPage(driver);
	}

	//    Find list of users on current page
	public List<User> getUsersFormCurrentPage() {
		final List<User> userEntityListFormCurrentPage = new ArrayList<>();
		final WebElement table = driver.findElement(By.tagName(TABLE_BODY));
		final List<WebElement> webElements = table.findElements(By.tagName(TR));
		for (WebElement rows : webElements) {
			final List<WebElement> tableCells = rows.findElements(By.tagName(TD));
			User user = new User ();
			user.setFirstname(tableCells.get(0).getText());
			user.setLastname(tableCells.get(1).getText());
			user.setLoginname(tableCells.get(2).getText());
			user.setRole(tableCells.get(3).getText().toUpperCase(Locale.ENGLISH));
			user.setRegion(tableCells.get(4).getText().toUpperCase(Locale.ENGLISH));
			userEntityListFormCurrentPage.add(user);
		}
		return userEntityListFormCurrentPage;
	}


	public int getQuantityOfUsersPerPage (){
		return getUsersFormCurrentPage().size();
	}

	// Get all users list from search result
	public List<User> getAllUsers() {
		final List<User> usersOnAllPages = new ArrayList<>();
		List<User> usersFromCurrentPage = this.getUsersFormCurrentPage();
		while (usersFromCurrentPage != null) {
			usersOnAllPages.addAll(usersFromCurrentPage);
			if (driver.findElement(By.id(FORWARD_BUTTON)).isEnabled()) {
				this.clickOnForwardButton();
				usersFromCurrentPage = this.getUsersFormCurrentPage();
			} else {
				break;
			}
		}
		return usersOnAllPages;
	}

	//Set default search
	public AdministrationPage setDefaultFilterConditions(){
		this.selectFieldFilterDropdownList(FieldFilterDropdownList.LOGIN)
				.selectConditionFilterDropdownList(ConditionFilterDropdownList.EQUALS)
				.clearSearchTextBox()
				.clickSearchButton();
		return this;
	}

	// Check if navigation buttons is enabled
	public boolean checkIsForwardButtonEnabled() {
		return driver.findElement(By.id(FORWARD_BUTTON)).isEnabled();
	}

	public boolean checkIsLastButtonEnabled() {
		return driver.findElement(By.id(LAST_BUTTON)).isEnabled();
	}

	public boolean checkIsBackwardButtonEnabled() {
		return driver.findElement(By.id(PREVIOUS_BUTTON)).isEnabled();
	}

	public boolean checkIsFirstButtonEnabled() {
		return driver.findElement(By.id(FIRST_BUTTON)).isEnabled();
	}

	//  Table result navigation buttons click
	public AdministrationPage clickOnForwardButton() {
		driver.findElement(By.id(FORWARD_BUTTON)).click();
		return this;
	}

	public AdministrationPage clickOnLastButton() {
		driver.findElement(By.id(LAST_BUTTON)).click();
		return this;
	}

	public AdministrationPage clickOnBackwardButton() {
		driver.findElement(By.id(PREVIOUS_BUTTON)).click();
		return this;
	}

	public AdministrationPage clickOnFirstButton() {
		driver.findElement(By.id(FIRST_BUTTON)).click();
		return this;
	}

	public int getFoundUsersNumber() {
		String foundUsers = driver.findElement(By.id(USERS_FOUND)).getAttribute("innerHTML");
		int UsersNumber = Integer.parseInt(foundUsers);
		return UsersNumber;
	}

	public int getPagesQuantity() {
		String foundUsers = driver.findElement(By.id(TOTAL_PAGE_NUMBER)).getAttribute("innerHTML");
		int UsersNumber = Integer.parseInt(foundUsers);
		return UsersNumber;
	}

	public String  getCurrentPageNumber() {
		String foundUsers = driver.findElement(By.id(CURRENT_PAGE_NUMBER)).getText();
		return foundUsers;
	}

	public CreateReportPage goToCreateReportPage() {
		driver.findElement(By.cssSelector(CREATE_REPORT_LINK_CSS)).click();
		return new CreateReportPage(this.driver);
	}

}


