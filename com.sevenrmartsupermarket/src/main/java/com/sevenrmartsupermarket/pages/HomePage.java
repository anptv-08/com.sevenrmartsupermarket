package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	
	@FindBy(xpath="//a[@class='d-block']")
	WebElement profileName;
	
	@FindBy(xpath="//li[@class='nav-item dropdown show']//a[@class='nav-link']")
	WebElement profileSettingsElement;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	WebElement logoutElement;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.get_Text(profileName);
	}
	
	public void logOut() {
		profileSettingsElement.click();
		logoutElement.click();
	}
}
