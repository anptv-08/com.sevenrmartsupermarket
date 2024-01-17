package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {

	WebDriver driver;
	GeneralUtility generalUtility;
	Properties properties = new Properties();
	FileInputStream ip;
	WaitUtility waitUtility;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameElement;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signInButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement invalidAlertElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSignInButton() {
		waitUtility=new WaitUtility();
		waitUtility.waitForButtonToBeClickable(driver, signInButton);
		signInButton.click();
	}

	public void login() {
		waitUtility=new WaitUtility();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitUtility.IMPLICIT_WAIT));
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public void login(String username, String password) {
		waitUtility=new WaitUtility();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitUtility.IMPLICIT_WAIT));
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}

	public boolean isInvalidAlertWindowDisplayed() {
		waitUtility=new WaitUtility();
		waitUtility.waitForVisibilityOfElement(driver, "//div[@class='alert alert-danger alert-dismissible']");
		generalUtility = new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(invalidAlertElement);
	}

	public String getInvalidAlertWindowText() {
		waitUtility=new WaitUtility();
		waitUtility.waitForVisibilityOfElement(driver, "//div[@class='alert alert-danger alert-dismissible']");
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_Text(invalidAlertElement);
	}
	
	public boolean isSignInButtonDisplayed() {
		waitUtility=new WaitUtility();
		waitUtility.waitForVisibilityOfElement(driver, "//button[text()='Sign In']");
		generalUtility=new GeneralUtility(driver);
		return generalUtility.element_IsDisplayed(signInButton);
	}

}
