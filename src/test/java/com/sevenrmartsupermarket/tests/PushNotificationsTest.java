package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.PushNotificationsPage;
import com.sevenrmartsupermarket.utilities.ExcelReadUtility;

public class PushNotificationsTest extends Base {

	PushNotificationsPage pushNotificationsPage;
	LoginPage loginPage;
	ExcelReadUtility excelRead=new ExcelReadUtility();
	SoftAssert softassert=new SoftAssert();;
	
	@Test(groups = "smoke")
	public void verifyPushNotificationMessage() throws InterruptedException {
		pushNotificationsPage=new PushNotificationsPage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login();
		excelRead.setExcelFile("PushNotifications", "Notification"); 
		pushNotificationsPage.clickOnPushNotifications();
		String title=excelRead.getCellData(1, 0);
		String description=excelRead.getCellData(1, 1);
		pushNotificationsPage.sendNotifications(title, description);
		softassert.assertTrue(pushNotificationsPage.isSuccessAlertDisplayed());
		softassert.assertAll();
		
	}
	
	@Test(groups = "smoke")
	public void verify() {}
}
