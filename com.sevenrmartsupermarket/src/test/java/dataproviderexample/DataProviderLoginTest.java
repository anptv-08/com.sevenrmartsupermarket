package dataproviderexample;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;

import dataprovideexample.pages.DataProviderLoginPage;


public class DataProviderLoginTest extends Base {

	DataProviderLoginPage dataProviderLoginPage;
	HomePage homePage;
	
	
	@Test(dataProvider = "7rmart supermarket Login", dataProviderClass=Data_Provider.class)
	public void verifyLoginUsingDataProvider(String userName, String password, String profileName) {
		dataProviderLoginPage=new DataProviderLoginPage(driver);
		homePage=new HomePage(driver);
		dataProviderLoginPage.login(userName, password);
		String actualProfileName=homePage.getProfileName();
		Assert.assertEquals(actualProfileName, profileName);
	}
}
