package com.crm.basic_utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectrepository_utility.HomePage;
import com.crm.objectrepository_utility.LoginPage;
import com.orangehrm.generic.databasesutility.DataBaseUtility;
import com.orangehrm.generic.fileutility.ExcelUtility;
import com.orangehrm.generic.fileutility.FileUtility;
import com.orangehrm.generic.webdriverutility.JavaUtility;
import com.orangehrm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {

	public WebDriver driver;
    public static WebDriver sdriver;//for Taking ScreenShot
	public FileUtility fUtil = new FileUtility();
	public DataBaseUtility dbUtil = new DataBaseUtility();
	public WebDriverUtility webUtil = new WebDriverUtility();
	public ExcelUtility ex = new ExcelUtility();
	public JavaUtility jut = new JavaUtility();
 
	public String BROWSER;
	public String URL;
	public String USERNAME;
	public String PASSWORD;

	@BeforeSuite
	public void connectToDataBase() throws ClassNotFoundException {
		//dbUtil.getDBConnection();
	}

	//@Parameters("BROWSER") //Cross Browser Test
	@BeforeClass             //String browser as arg
	public void launchBrowser() throws IOException {
		BROWSER=fUtil.getDataFromPropertiesFile("browser");
		// BROWSER=browser;  //Cross Browser Test
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;//Taking ScreenShot
		webUtil.waitForPageToLoad(driver);
		webUtil.maximizeWindow(driver);
	}

	@BeforeMethod
	public void loginToApplication() throws IOException {
		URL = fUtil.getDataFromPropertiesFile("url");
		driver.get(URL);
		USERNAME = fUtil.getDataFromPropertiesFile("username");
		PASSWORD = fUtil.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod
	public void logoutFromApplication() {
		HomePage hm = new HomePage(driver);
		hm.logout();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite
	public void closeDbConnection() {
		//dbUtil.closeConnection();
	}

}
