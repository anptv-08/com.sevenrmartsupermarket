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
	public void verifyDeliverBoyEditUserName() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoyUserName("George Bayer V");	
		String actualUserName=faker.name().firstName()+"23";
		manageDeliveryBoyPage.enterUserName(actualUserName);
		manageDeliveryBoyPage.clickOnUpdateButton();
		String expectedName=manageDeliveryBoyPage.getNameText("George Bayer V");
		softassert.assertEquals(actualUserName, expectedName);
		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
		softassert.assertAll();
	}
	
	@Test(groups="smoke")
	public void verifyDeliverBoyEditWithPhoneNumberFieldEmpty() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.editDeliveryBoyPhoneNumber("George Bayer V");	
		String expectedAlertMessageText="The Phone Number field is required.";
		String actualAlertMessageText=manageDeliveryBoyPage.phoneNumberRequiredFieldWarningAlertMessageText();
		softassert.assertTrue(manageDeliveryBoyPage.isWarningAlertDisplayed());
		softassert.assertEquals(actualAlertMessageText, expectedAlertMessageText);
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
		softassert.assertTrue(manageDeliveryBoyPage.isSuccessMessageAlertDisplayed());
		softassert.assertAll();
	}
	
	@Test(groups={"smoke","regresion"})
	public void verifyCreatingNewDeliveryBoy1() {
		loginPage=new LoginPage(driver);
		manageDeliveryBoyPage=new ManageDeliveryBoyPage(driver);	
		loginPage.login();
		manageDeliveryBoyPage.clickOnManageDeliveryBoy();
		manageDeliveryBoyPage.clickOnCreateNewDeliveryBoy();
		String name = manageDeliveryBoyPage.getRandomName();
		String email=manageDeliveryBoyPage.getRandomEmail();
		String phone=manageDeliveryBoyPage.getRandomPhoneNumber();
		String username=manageDeliveryBoyPage.getRandomUserName();
		String password=manageDeliveryBoyPage.getRandomPassword();
		String address = manageDeliveryBoyPage.getRandomAddress();
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
