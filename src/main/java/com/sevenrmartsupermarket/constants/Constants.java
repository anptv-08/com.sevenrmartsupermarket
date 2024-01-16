package com.sevenrmartsupermarket.constants;

public class Constants {

//	public static final String CONFIG_FILE_PATH="D:\\JenkinsWorkspace\\com.sevenrmartsupermarket\\src\\main\\resources\\config.properties";
//	public static final String EXCEL_FILE_PATH="D:\\JenkinsWorkspace\\com.sevenrmartsupermarket\\src\\main\\resources\\Excel_Files\\";
//	public static final String SCREENSHOT_FILE_PATH="D:\\JenkinsWorkspace\\com.sevenrmartsupermarket\\ScreenShots\\";
//	public static final String EXTENT_REPORT_PATH="D:\\JenkinsWorkspace\\com.sevenrmartsupermarket\\Extent_Reports";
	
public static final String CONFIG_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"; // file path of Config.properies files 
//System.getProperty("user.dir") will return project path in local+ remaining path of folder is same for everyone.
public static final String EXCEL_FILE_PATH=System.getProperty("user.dir")+"\\src\\main\\resources\\Excel_Files\\";
public static final String SCREENSHOT_FILE_PATH=System.getProperty("user.dir")+"\\ScreenShots\\";
public static final String EXTENT_REPORT_PATH=System.getProperty("user.dir")+"\\Extent_Reports";
}
