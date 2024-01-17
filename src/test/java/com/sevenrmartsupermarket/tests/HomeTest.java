package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	HomePage homePage;
	LoginPage loginPage;
	SoftAssert softassert=new SoftAssert();
	 
	@Test
	public void verifyLogout() {
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login();
		homePage.logOut();
		softassert.assertTrue(homePage.isSignInButtonDisplayed());
		softassert.assertAll();
	}
	
	@Test
	public void verifyDashBordElements() {
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		loginPage.login();
		List<String> expectedDashBoardElements=homePage.getExpectedDashBoardElementsText();	
		List<String> actualDashBoardElements=homePage.getDashBoardElementsText();
		softassert.assertEquals(actualDashBoardElements, expectedDashBoardElements);
		softassert.assertAll();
	}
}
