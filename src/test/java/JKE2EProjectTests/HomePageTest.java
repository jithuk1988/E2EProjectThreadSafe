package JKE2EProjectTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import util.Utils;

public class HomePageTest extends Utils {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
	}
	
	@Test(description="Verify all the side menu items are displayed")
	public void HomeTest() throws IOException {

		LoginPage lp = new LoginPage(driver);
		log.info("Login page loaded");
		lp.getusername().clear();
		lp.getusername().sendKeys("admin@yourstore.com");
		lp.getpassword().clear();
		lp.getpassword().sendKeys("admin");
		lp.clickLogin();
		log.info("Login Successfull");
		HomePage hp = new HomePage(driver);
		String userid=hp.getuser().getText();
		log.info("User id verified");
//		System.out.println(userid);
		String dashboardtitle = hp.getdashboardtitle().getText();
//		System.out.println(dashboardtitle);
		log.info("Verifying Side menu links");
		Assert.assertEquals("Dashboard", dashboardtitle);
		Assert.assertTrue(hp.getSidemenu_cataglog().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Configuration().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Cont_mgmnt().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Customers().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Promotions().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Reports().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_Sales().isDisplayed());
		Assert.assertTrue(hp.getSidemenu_System().isDisplayed());
		log.info("Side menu verification completed");
		hp.clickLogoutlink();
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	}
	

