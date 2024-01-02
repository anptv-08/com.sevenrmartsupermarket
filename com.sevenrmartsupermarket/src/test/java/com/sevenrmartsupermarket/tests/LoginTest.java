package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelRead;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	ExcelRead excelRead=new ExcelRead();

	@Test
	public void verifyLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin");
		homePage = new HomePage(driver);
		String actualProfileName = homePage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}

	

	
	@Test
	public void excelRead() {
		excelRead.setExcelFile("LoginCredentials", "Valid Login Credentials"); //Workbookname & sheetName
		String username1=excelRead.getCellData(1, 0);
		String password1=excelRead.getCellData(1, 1);
		System.out.println(username1);
		System.out.println(password1);
	}
}
