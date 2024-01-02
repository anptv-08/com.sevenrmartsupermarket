package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class PushNotificationsPage {

	WebDriver driver;
	GeneralUtility generalUtility;
	
	@FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//li[6]")
	WebElement pushNotificationsElement;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement titleElement;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement descriptionElement;
	
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")
	WebElement sendButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertElement;
	
	public PushNotificationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnPushNotifications() {
		pushNotificationsElement.click();
	}
	
	public void enterTitle(String title){
		titleElement.sendKeys(title);
	}
	public void enterDescription(String description){
		descriptionElement.sendKeys(description);
	}
	
	public void clickOnSendButton() {
		WaitUtility.waitForButtonToBeClickable(driver, sendButton);
		sendButton.click();
	}
	
	public boolean isSuccessAlertDisplayed() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(successAlertElement);
	}
	
	public void sendNotifications(String title,String description) {
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}
	
}
