package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	WebDriver driver;
	Faker faker=new Faker();

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public String generateRandomName() {
		return faker.name().fullName();
	}
	
	public String generateRandomFirstName() {
		return faker.name().firstName();
	}
	
	public String generateRandomLastName() {
		return faker.name().lastName();
	}
	
	public String generateRandomAddress() {
		return faker.address().streetAddress();
	}
	
	public String generateRandomPhoneNumber() {
		return Long.toString(faker.number().randomNumber(10, false));
	}
	
	public String generateRandomEmail() {
		return faker.name().firstName()+"@gmail.com";
	}
	
	public String generateRandomUserName() {
		return faker.name().firstName()+"2023";
	}
	
	public String generateRandomPassword() {
		return faker.name().lastName()+"123";
	}

	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String get_CssValue(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public String get_Text(WebElement element) {
		return element.getText();
	}

	public boolean element_IsDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean element_IsEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean element_IsSelected(WebElement element) {
		return element.isSelected();
	}
	
	public String getJSAlertText() {
		return driver.switchTo().alert().getText();
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> textOfElement = new ArrayList<String>();
		for (WebElement element : elements) {
			textOfElement.add(element.getText());
		}
		return textOfElement;
	}
}
