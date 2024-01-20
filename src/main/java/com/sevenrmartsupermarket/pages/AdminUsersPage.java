package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUsersPage {

WebDriver driver;
HomePage homePage;
GeneralUtility generalUtility;
PageUtility pageUtility;
WaitUtility waitUtility=new WaitUtility();;

@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//li[15]")
private WebElement adminUsersElement;

@FindBy(xpath="//div[@class='col-sm-12']//a[@class='btn btn-rounded btn-danger']")
private WebElement createNewUserElement;

@FindBy(xpath="//input[@id='username']")
private WebElement usernameElement;

@FindBy(xpath="//input[@id='password']")
private WebElement passwordElement;

@FindBy(xpath="//select[@id='user_type']")
private WebElement userTypeSelectElement;

@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Create']")
private WebElement saveButton;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]/td[1]")
private WebElement firstUserUsernameElement;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]/td[2]")
private WebElement firstUserUserTypeElememt;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]/td[4]//i")
private WebElement showPasswordElement;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]/td")
private WebElement firstUserPasswordElement;

@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]//span")
private WebElement firstUserStatus;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement successMessageAlert;

public AdminUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnAdminUsersElement() {
	pageUtility=new PageUtility(driver);
	waitUtility.waitForButtonToBeClickable(driver, adminUsersElement);
	pageUtility.scroll_AndClick(adminUsersElement);
}

public String getRandomUserName() {
	generalUtility=new GeneralUtility(driver);
	return generalUtility.generateRandomUserName();
}

public String getRandomPassword() {
	generalUtility=new GeneralUtility(driver);
	return generalUtility.generateRandomPassword();
}

public void enterUsername(String username) {
	usernameElement.sendKeys(username);
}
public void enterPassword(String password) {
	passwordElement.sendKeys(password);
}

public void clickOnCreateNewUserElement() {
	pageUtility=new PageUtility(driver);
	pageUtility.scroll_AndClick(createNewUserElement);
}

public void selectUserType(String selectValue) {
	pageUtility=new PageUtility(driver);
	pageUtility.select_ByValue(userTypeSelectElement, selectValue);
}

public void clickOnSaveButton() {
	pageUtility=new PageUtility(driver);
	waitUtility.waitForButtonToBeClickable(driver, saveButton);
	pageUtility.scroll_AndClick(saveButton);
}

public String getActualUsername() {
	generalUtility=new GeneralUtility(driver);
	return generalUtility.get_Text(firstUserUsernameElement);
}

public String getActualPassword() {
	generalUtility=new GeneralUtility(driver);
	showPasswordElement.click();
	String password=generalUtility.get_Text(firstUserPasswordElement);
	return password.substring(11);
}

public String getActualUserType() {
	generalUtility=new GeneralUtility(driver);
	return generalUtility.get_Text(firstUserUserTypeElememt);
}

public String getActualUserStatus() {
	generalUtility=new GeneralUtility(driver);
	return generalUtility.get_Text(firstUserStatus);
}

public boolean isSuccessMessageAlertVisible() {
	generalUtility=new GeneralUtility(driver);
	waitUtility.waitForVisibilityOfElement(driver, "//div[@class='alert alert-success alert-dismissible']");
	return generalUtility.element_IsDisplayed(successMessageAlert);
}

}
