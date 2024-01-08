package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReadUtility;

public class LoginTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	ExcelReadUtility excelRead = new ExcelReadUtility();
	Faker faker = new Faker();

	@Test(groups = "regression", retryAnalyzer = RetryAnalyzer.class)
	public void verifyLogin() {
		loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin");
		homePage = new HomePage(driver);
		String actualProfileName = homePage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test(groups = "smoke")
	public void excelRead() {
		excelRead.setExcelFile("LoginCredentials", "Valid Login Credentials"); // Workbookname & sheetName
		String username1 = excelRead.getCellData(1, 0);
		String password1 = excelRead.getCellData(1, 1);
		System.out.println(username1);
		System.out.println(password1);
	}

	@Test(dataProvider = "SevenMart SuperMarket Valid Login", dataProviderClass = com.sevenrmartsupermarket.base.Data_Provider.class)
	public void verifyLoginUsingDataProvider(String userName, String password, String profileName) {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login(userName, password);
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, profileName);
	}
}
