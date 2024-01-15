package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReadUtility;

public class Data_Provider {
	ExcelReadUtility excelRead=new ExcelReadUtility();

	@DataProvider(name="7rmart supermarket Login")
	public Object[][] SevenRMartSuperMarketLogin()
	{
		return new Object [][] {{"admin","admin","Admin"},{"pinky","selenium","Pinky"},{"Shameena","Batch5","Shameena"},{"name7","name1","Name7"}};
	}
	
	@DataProvider(name="SevenMart SuperMarket Valid Login")
	public Object[][] sevenMartValidLogin(){
		excelRead.setExcelFile("LoginCredentials", "Valid Login Credentials");
		Object data[][] = excelRead.getMultidimentionalData(3, 3); // row, column
		return data;
	}
}
