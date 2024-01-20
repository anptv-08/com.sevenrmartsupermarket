package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUsersTest extends Base {

	LoginPage loginPage;
	AdminUsersPage adminUsersPage;
	SoftAssert softassert=new SoftAssert();
	
	@Test
	public void verifyCreatingNewAdminUser() {
		loginPage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginPage.login();
		adminUsersPage.clickOnAdminUsersElement();
		adminUsersPage.clickOnCreateNewUserElement();
		String expectedUsername=adminUsersPage.getRandomUserName();
		String expectedPassword=adminUsersPage.getRandomPassword();
		String expectUserType="admin";
		String expectedUserStatus="active";
		adminUsersPage.enterUsername(expectedUsername);
		adminUsersPage.enterPassword(expectedPassword);
		adminUsersPage.selectUserType(expectUserType);
		adminUsersPage.clickOnSaveButton();
		String actualUsername=adminUsersPage.getActualUsername();
		String actualPassword=adminUsersPage.getActualPassword();
		String actualUserType=adminUsersPage.getActualUserType();
		String actualUserStatus=adminUsersPage.getActualUserStatus();
		softassert.assertEquals(actualUsername, expectedUsername);
		softassert.assertEquals(actualPassword, expectedPassword);
		softassert.assertEquals(actualUserType, expectUserType);
		softassert.assertEquals(actualUserStatus, expectedUserStatus);
		softassert.assertTrue(adminUsersPage.isSuccessMessageAlertVisible());
	}
	
	@Test
	public void verifyInactivatingAdminUser() {
		loginPage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginPage.login();
		adminUsersPage.clickOnAdminUsersElement();
	}
}
