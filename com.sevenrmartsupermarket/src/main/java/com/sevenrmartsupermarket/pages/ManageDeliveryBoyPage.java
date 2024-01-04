package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column']//li[13]")
	WebElement manageDeliveryBoyElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> nameElements;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement createNewDeliveryBoyElement;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMessage;

	@FindBy(xpath = "//input[@id='name']")
	WebElement nameElement;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailElement;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneElement;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement addressElement;

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameElement;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement updateButton;
	
	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[7]//a[1])[1]")
	WebElement showPasswordElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td")
	WebElement passwordDataElement;
	
	
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td")
	List<WebElement> deliveryBoyRowDataElement;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliveryBoy() {
		manageDeliveryBoyElement.click();
	}

	public void clickOnCreateNewDeliveryBoy() {
		createNewDeliveryBoyElement.click();
	}

	public void enterName(String name) {
		nameElement.sendKeys(name);
	}

	public void enterEmail(String email) {
		emailElement.sendKeys(email);
	}

	public void enterPhoneNumber(String phone) {
		phoneElement.sendKeys(phone);
	}

	public void enterAddress(String address) {
		addressElement.sendKeys(address);
	}

	public void enterUserName(String username) {
		usernameElement.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSaveButton() {
		pageUtility=new PageUtility(driver);
		WaitUtility.waitForButtonToBeClickable(driver, saveButton);
		pageUtility.scroll_AndClick(saveButton);
		
	}
	
	public void clickOnUpdateButton() {
		pageUtility=new PageUtility(driver);
		WaitUtility.waitForButtonToBeClickable(driver, saveButton);
		pageUtility.scroll_AndClick(updateButton);
	}
	
	public void clearName() {
		nameElement.clear();
	}

	public void sendDeliveryBoyData(String name, String email, String phone, String address, String username,
			String password) {
		enterName(name);
		enterEmail(email);
		enterPhoneNumber(phone);
		enterAddress(address);
		enterUserName(username);
		enterPassword(password);
		clickOnSaveButton();
	}
	
	public List<String> getDeliveryBoyDetails() {
		generalUtility=new GeneralUtility(driver);
		List<String> rowDatas=generalUtility.getTextOfElements(deliveryBoyRowDataElement);
		return rowDatas;
	}
	
	public String getPasswordText() {
		generalUtility=new GeneralUtility(driver);
		clickOnShowPasswordElement();
		return generalUtility.get_Text(passwordDataElement);
	}

	public void editDeliveryBoy(String deliveryBoyName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		int index = 0;
		List<String> names = new ArrayList<String>();
		names = generalUtility.getTextOfElements(nameElements);
		for (index = 0; index < names.size(); index++) {
			if (deliveryBoyName.equals(names.get(index))) {
				index++;
				break;
			}
		}
		WebElement editDeliveryBoyElement = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody/tr[" + index + "]/td[8]//a[1]"));
		pageUtility.scroll_AndClick(editDeliveryBoyElement);
		clearName();
	}
	
	public boolean isSuccessMessageAlertDisplayed() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(successAlertMessage);
	}
	
	public void clickOnShowPasswordElement() {
		showPasswordElement.click();
	}
}
