package JKE2EProjectTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.base;
import pageObjects.LoginPage;
import util.Utils;

public class LoginPageTest extends Utils{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}
	
	@Test(dataProvider = "getData",description="Verify logging in with two different users")
	public void LoginTest(String username, String password,String text) throws IOException
	{
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login Page");
		LoginPage lp = new LoginPage(driver);
		lp.getusername().clear();
		lp.getusername().sendKeys(username);
		lp.getpassword().clear();
		lp.getpassword().sendKeys(password);
		lp.clickLogin();
		log.info("Login Successfull");
		System.out.println("User Type: " + text);
	}
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types test should run
		//For sending three values two times, then [2][3]
		//Column stands for number of values
		Object[][] data = new Object[2][3];
		data[0][0] = "admin@yourstore.com";
		data[0][1] = "admin";
		data[0][2] = "SuperAdmin";
		data[1][0] = "ADMIN@YOURSTORE.com";
		data[1][1] = "admin";
		data[1][2] = "Admin";		
		return data;
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
