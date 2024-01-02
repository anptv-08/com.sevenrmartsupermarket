package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
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

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> textOfElement = new ArrayList<String>();
		for (WebElement element : elements) {
			textOfElement.add(element.getText());
		}
		return textOfElement;
	}
}
