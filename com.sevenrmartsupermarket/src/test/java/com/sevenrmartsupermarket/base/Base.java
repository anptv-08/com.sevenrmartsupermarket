package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenShot;
import com.sevenrmartsupermarket.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties=new Properties();
	FileInputStream ip;
	ScreenShot screenShot=new ScreenShot();
	
	/** Initializing config file **/
	
	public Base() {
		try {
			ip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Launching browser **/
	public void initialize(String browser, String url) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}

	@BeforeMethod
	public void launchBrowser() {
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		initialize(browser, url);
	}
	
	@AfterMethod
	public void terminateSession(ITestResult itestresult) {
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			screenShot.takeScreenShot(driver, itestresult.getName());
		}
	}

}
