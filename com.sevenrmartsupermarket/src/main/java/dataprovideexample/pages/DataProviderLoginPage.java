package dataprovideexample.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class DataProviderLoginPage {

	WebDriver driver;
	GeneralUtility generalUtility;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameElement;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement invalidAlertElement;
	
	public DataProviderLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		userNameElement.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public void login(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnSignInButton();
	}
	
	
}
