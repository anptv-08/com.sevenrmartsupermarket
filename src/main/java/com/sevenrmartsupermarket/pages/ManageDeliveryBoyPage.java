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
	private WebElement manageDeliveryBoyElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	private List<WebElement> nameElements;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement createNewDeliveryBoyElement;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningAlertMessage;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameElement;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailElement;

	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneElement;

	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressElement;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameElement;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	private WebElement updateButton;
	
	@FindBy(xpath="(//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[7]//a[1])[1]")
	private WebElement showPasswordElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[2]//td")
	private WebElement passwordDataElement;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']//div[@class='errors']//li")
	private WebElement phoneNumberRequiredFiledWarningAlert;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td")
	private List<WebElement> deliveryBoyRowDataElement;

	@FindBy(xpath="//ul[@class='pagination pagination-sm m-0 float-right']//li//a[@aria-label='Next']")
	private WebElement nextPage;
	
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
	
	public void clearEmail() {
		emailElement.clear();
	}
	public void clearUserName() {
		usernameElement.clear();
	}
	
	public void clearPhoneNumber() {
		phoneElement.clear();
	}
	
	public String getRandomName() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomName();
	}
	
	public String getRandomEmail() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomEmail();
	}
	
	public String getRandomPhoneNumber() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomPhoneNumber();
	}
	
	public String getRandomAddress() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomAddress();
	}
	
	public String getRandomUserName() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomUserName();
	}
	
	public String getRandomPassword() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.generateRandomPassword();
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
	
	public String phoneNumberRequiredFieldWarningAlertMessageText() {
		generalUtility=new GeneralUtility(driver);
		clickOnUpdateButton();
		return generalUtility.get_Text(phoneNumberRequiredFiledWarningAlert);	
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

	public void editDeliveryBoyUserName(String deliveryBoyName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		int listindex;
		boolean elementFound=false;
		for (int i = 1; i <= 94; i++) {
			List<String> nameText = generalUtility.getTextOfElements(nameElements);
			for (listindex = 0; listindex < nameText.size(); listindex++) {
				if (deliveryBoyName.equals(nameText.get(listindex))) {
					listindex++;
					WebElement editDeliveryBoyElement = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["
									+ listindex + "]/td[8]//a[1]"));
					pageUtility.scroll_AndClick(editDeliveryBoyElement);
					clearUserName();
					elementFound = true;
					break;
				}

			}
			if(elementFound) {
				break;
			}
			if (listindex == nameText.size()) {
				pageUtility.scroll_AndClick(nextPage);
			}
		}
	}
	
	public void editDeliveryBoyEmail(String deliveryBoyName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		int listindex;
		boolean elementFound=false;
		for (int i = 1; i <= 94; i++) {
			List<String> nameText = generalUtility.getTextOfElements(nameElements);
			for (listindex = 0; listindex < nameText.size(); listindex++) {
				if (deliveryBoyName.equals(nameText.get(listindex))) {
					listindex++;
					WebElement editDeliveryBoyElement = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["
									+ listindex + "]/td[8]//a[1]"));
					pageUtility.scroll_AndClick(editDeliveryBoyElement);
					clearEmail();
					elementFound = true;
					break;
				}

			}
			if(elementFound) {
				break;
			}
			if (listindex == nameText.size()) {
				pageUtility.scroll_AndClick(nextPage);
			}
		}
	}
	
	public void editDeliveryBoyPhoneNumber(String deliveryBoyName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		int listindex;
		boolean elementFound=false;
		for (int i = 1; i <= 94; i++) {
			List<String> nameText = generalUtility.getTextOfElements(nameElements);
			for (listindex = 0; listindex < nameText.size(); listindex++) {
				if (deliveryBoyName.equals(nameText.get(listindex))) {
					listindex++;
					WebElement editDeliveryBoyElement = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["
									+ listindex + "]/td[8]//a[1]"));
					pageUtility.scroll_AndClick(editDeliveryBoyElement);
					clearPhoneNumber();
					elementFound = true;
					break;
				}

			}
			if(elementFound) {
				break;
			}
			if (listindex == nameText.size()) {
				pageUtility.scroll_AndClick(nextPage);
			}
		}
	}
	
	public String getNameText(String deliveryBoyName) {
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
		WebElement deliveryBoyNameElement=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["+index+"]//td[5]"));
		return generalUtility.get_Text(deliveryBoyNameElement);
	}
	
	public String getEmailText(String deliveryBoyName) {
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
		WebElement deliveryBoyEmailElement=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["+index+"]//td[2]"));
		
		System.out.println("Email: "+deliveryBoyEmailElement.getText());
		return generalUtility.get_Text(deliveryBoyEmailElement);
	}
	
	public String getPhoneNumberText(String deliveryBoyName) {
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
		WebElement deliveryBoyPhoneNumberElement=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody/tr["+index+"]//td[3]"));
		
		System.out.println("Email: "+deliveryBoyPhoneNumberElement.getText());
		return generalUtility.get_Text(deliveryBoyPhoneNumberElement);
	}
	
	public boolean isSuccessMessageAlertDisplayed() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(successAlertMessage);
	}
	
	public boolean isWarningAlertDisplayed() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(warningAlertMessage);
	}
	
	public String getBackgroundColorOfSuccessMessageAlert() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.get_CssValue(successAlertMessage,"background-color" );
	}
	
	public void clickOnShowPasswordElement() {
		showPasswordElement.click();
	}
}
