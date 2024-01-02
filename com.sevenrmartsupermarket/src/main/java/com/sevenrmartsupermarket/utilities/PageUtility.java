package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	Actions actions;
	Select select;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void moveMouseTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void select_ByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void select_ByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void select_ByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByValue(visibleText);
	}

	public void scroll_AndClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		int y = 0;
		while (!(isClicked(element))) {
			js.executeScript("window.scrollBy(0," + y + ")");
			y = y + 2;
		}
	}

	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
