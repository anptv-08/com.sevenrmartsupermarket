package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	LoginPage loginPage;
	
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement profileName;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']//a[@class='nav-link']")
	private WebElement profileSettingsElement;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement logoutElement;
	
	@FindBy(xpath="//div[@class='small-box bg-info']//div[@class='inner']//p")
	private List<WebElement> dashBoardElements;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		generalUtility=new GeneralUtility(driver);
		return generalUtility.get_Text(profileName);
	}
	
	public void logOut() {
		WaitUtility.waitForButtonToBeClickable(driver, profileSettingsElement);
		profileSettingsElement.click();
		WaitUtility.waitForButtonToBeClickable(driver, logoutElement);
		logoutElement.click();
	}
	
	public boolean isSignInButtonDisplayed() {
		loginPage=new LoginPage(driver);
		return loginPage.isSignInButtonDisplayed();
	}
	
	public List<String> getDashBoardElementsText(){
		generalUtility=new GeneralUtility(driver);
		List<String> dashBoardElementsName=generalUtility.getTextOfElements(dashBoardElements);
		return dashBoardElementsName;
	}
	
	public List<String> getExpectedDashBoardElementsText(){
		List<String> expectedDashBoardElements=new ArrayList<String>();
		expectedDashBoardElements.add("Manage Pages");
		expectedDashBoardElements.add("Admin Users");
		expectedDashBoardElements.add("Dashboard");
		expectedDashBoardElements.add("Category");
		expectedDashBoardElements.add("Manage Product");
		expectedDashBoardElements.add("Manage Offer Code");
		expectedDashBoardElements.add("Manage Slider");
		expectedDashBoardElements.add("Manage Delivery Boy");
		expectedDashBoardElements.add("Manage Users");
		expectedDashBoardElements.add("Manage Orders");
		expectedDashBoardElements.add("Manage Location");
		expectedDashBoardElements.add("Mobile Slider");
		expectedDashBoardElements.add("Manage News");
		expectedDashBoardElements.add("Manage Expense");
		expectedDashBoardElements.add("Manage Gift cards &vouchers");
		expectedDashBoardElements.add("Manage Gift cards &vouchers");
		return expectedDashBoardElements;
		
	}
}
