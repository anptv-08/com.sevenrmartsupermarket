package com.sevenrmartsupermarket.tests;

import java.util.List;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.utilities.ExcelReadUtility;
import com.sevenrmartsupermarket.utilities.ScreenShotUtility;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage manageDeliveryBoyPage;
	LoginPage loginPage;
	ExcelReadUtility excelRead=new ExcelReadUtility();
	SoftAssert softassert=new SoftAssert();
	Faker faker=new Faker();
	
	
	@Test(groups="smoke")
	public void verifyDeliverBoyEditName() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoyName("name16");	
		String actualName=faker.name().firstName();
		manageDeliveryBoyPage.enterName(actualName);
		manageDeliveryBoyPage.clickOnUpdateButton();
		String expectedName=manageDeliveryBoyPage.getNameText(actualName);
		softassert.assertEquals(actualName, expectedName);
		softassert.assertAll();
	}
	
	@Test(groups="smoke")
	public void verifyDeliverBoyEditEmail() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoyEmail("Elissa");	
		String actualEmail=faker.name().firstName()+"@hotmail.com";
		manageDeliveryBoyPage.enterEmail(actualEmail);
		manageDeliveryBoyPage.clickOnUpdateButton();
		String expectedEmail=manageDeliveryBoyPage.getEmailText("Elissa");
		softassert.assertEquals(actualEmail, expectedEmail);
		softassert.assertAll();
	}
	
//	@Test(groups={"smoke","regresion"})
//	public void verifyCreatingNewDeliveryBoy() {
//		loginPage=new LoginPage(driver);
//		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
//		loginPage.login();
//		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
//		manageDeliveryBoyPage.clickOnCreateNewDeliveryBoy();
//		excelRead.setExcelFile("CreateDeliveryBoy", "Vaid Delivery Boy");
//		String name=excelRead.getCellData(8, 0);
//		String email=excelRead.getCellData(8, 1);
//		String phone=excelRead.getCellData(8, 2);
//		String address=excelRead.getCellData(8, 3);
//		String username=excelRead.getCellData(8, 4);
//		String password=excelRead.getCellData(8, 5);
//		manageDeliveryBoyPage.sendDeliveryBoyData(name, email, phone, address, username, password);
//		List<String> actualData=manageDeliveryBoyPage.getDeliveryBoyDetails();
//		softassert.assertEquals(actualData.get(0), name);
//		softassert.assertEquals(actualData.get(1), email);
//		softassert.assertEquals(actualData.get(2), phone);
//		softassert.assertEquals(actualData.get(3), address);
//		softassert.assertEquals(actualData.get(4), username);
//		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
//		softassert.assertAll();
//	}
	
	@Test(groups={"smoke","regresion"})
	public void verifyCreatingNewDeliveryBoy1() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.clickOnCreateNewDeliveryBoy();
		String name = faker.name().fullName();
//		String firstName = faker.name().firstName();
//		String lastName = faker.name().lastName();
		String email=faker.name().firstName()+"@gmail.com";
		String phone=Long.toString(faker.number().randomNumber(10, false));
		System.out.println(phone);
		String username=faker.name().firstName()+"2023";
		String password=faker.name().lastName()+"123";
		String address = faker.address().streetAddress();
		manageDeliveryBoyPage.sendDeliveryBoyData(name, email, phone, address, username, password);
		List<String> actualData=manageDeliveryBoyPage.getDeliveryBoyDetails();
		softassert.assertEquals(actualData.get(0), name);
		softassert.assertEquals(actualData.get(1), email);
		softassert.assertEquals(actualData.get(2), phone);
		softassert.assertEquals(actualData.get(4), username);
		String actualPassword=manageDeliveryBoyPage.getPasswordText();
		softassert.assertEquals(actualPassword.substring(11), password);
		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
		System.out.println(manageDeliveryBoyPage.getBackgroundColorOfSuccessMessageAlert());
		softassert.assertAll();
	}
	
}
