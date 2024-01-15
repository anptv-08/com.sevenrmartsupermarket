package com.sevenrmartsupermarket.utilities;

import java.io.File;

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
	File file;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void moveMouseTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void mouseClick() {
		actions=new Actions(driver);
		actions.click().build().perform();
	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void dragAndDropElements(WebElement sourceElement, WebElement destinationElement) {
		actions=new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).build().perform();
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
	
	public void uploadFile(WebElement element, String path) {
		file=new File(path);
		element.sendKeys(file.getAbsolutePath());	
	}
	
//	public void handleJSAlertOK() {
//		driver.switchTo().alert().accept();
//	}
//	
//	public void handleJSAlertDismiss() {
//		driver.switchTo().alert().dismiss();
//	}
//	
//	public void handleJSAlertPrompt(String message) {
//		driver.switchTo().alert().sendKeys(message);
//		handleJSAlertOK();
//	}
//	
//	public void switchToIFrame(WebElement element) {
//		driver.switchTo().frame(element);
//	}
//	
//	public void switchToDefaultContent() {
//		driver.switchTo().defaultContent();
//	}
	

}
