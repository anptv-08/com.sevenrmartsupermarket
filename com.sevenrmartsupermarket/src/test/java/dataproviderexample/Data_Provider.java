package dataproviderexample;

import org.testng.annotations.DataProvider;

public class Data_Provider {

	@DataProvider(name="7rmart supermarket Login")
	public Object[][] SevenRMartSuperMarketLogin()
	{
		return new Object [][] {{"admin","admin","Admin"},{"pinky","selenium","Pinky"},{"Shameena","Batch5","Shameena"},{"name7","name1","Name7"}};
	}
}
