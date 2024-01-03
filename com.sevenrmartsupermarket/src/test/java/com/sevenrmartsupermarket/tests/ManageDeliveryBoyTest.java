package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoyPage;
	LoginPage loginPage;
	ExcelRead excelRead=new ExcelRead();
	SoftAssert softassert=new SoftAssert();
	
	
	@Test(groups="smoke")
	public void verifyDeliverBoyEdit() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoy("ShameenaPS");	
		manageDeliveryBoyPage.enterName("Rahul");
		manageDeliveryBoyPage.clickOnUpdateButton();
	}
	
	@Test(groups={"smoke","regresion"})
	public void verifyCreatingNewDeliveryBoy() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.clickOnCreateNewDeliveryBoy();
		excelRead.setExcelFile("CreateDeliveryBoy", "Vaid Delivery Boy");
		String name=excelRead.getCellData(8, 0);
		String email=excelRead.getCellData(8, 1);
		String phone=excelRead.getCellData(8, 2);
		String address=excelRead.getCellData(8, 3);
		String username=excelRead.getCellData(8, 4);
		String password=excelRead.getCellData(8, 5);
		manageDeliveryBoyPage.sendDeliveryBoyData(name, email, phone, address, username, password);
		List<String> actualData=manageDeliveryBoyPage.getDeliveryBoyDetails();
		softassert.assertEquals(actualData.get(0), name);
		softassert.assertEquals(actualData.get(1), email);
		softassert.assertEquals(actualData.get(2), phone);
	//	softassert.assertEquals(actualData.get(3), address);
		softassert.assertEquals(actualData.get(4), username);
		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
		softassert.assertAll();
		
	}
}
