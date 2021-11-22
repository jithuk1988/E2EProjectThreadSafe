package JKE2EProjectTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageObjects.CustomerPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class CustomerPageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Driver is initialized");
		LoginPage lp = new LoginPage(driver);
		log.info("Login page loaded");
		lp.getusername().clear();
		lp.getusername().sendKeys("admin@yourstore.com");
		lp.getpassword().clear();
		lp.getpassword().sendKeys("admin");
		lp.clickLogin();
		log.info("Login Completed");
	}
	
	@Test(description = "Verify searching of customers using Email ID")
	public void CustomerPageSearchEmailTest() throws IOException {


		HomePage hp = new HomePage(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",hp.sideMenu_customer_role_link());    
		hp.SideMenu_Customers().click();
		CustomerPage cp = new CustomerPage(driver);
		cp.get_textbox_email_search().sendKeys("james_pan@nopCommerce.com");
		cp.get_search_button().click();
		Assert.assertTrue(cp.get_search_email_result().isDisplayed());
		Assert.assertEquals(cp.get_grid_result_info().getText(), "1-1 of 1 items");
		log.info("Customer page search by Email completed");
		driver.navigate().refresh();
		
	}
	
	@Test(description = "Verify searching of customers using First Name")
	public void CustomerPageSearchFirstNameTest() throws IOException {


		HomePage hp = new HomePage(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",hp.sideMenu_customer_role_link());    
		hp.SideMenu_Customers().click();
		CustomerPage cp = new CustomerPage(driver);
		cp.get_textbox_firstName_serarch().sendKeys("Arthur");
		cp.get_search_button().click();
		Assert.assertTrue(cp.get_search_firstName_result().isDisplayed());
		Assert.assertEquals(cp.get_grid_result_info().getText(), "1-1 of 1 items");
		log.info("Customer page search by First Name completed");

	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	}
	

