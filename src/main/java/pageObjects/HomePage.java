package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	@FindBy(xpath = "//*[@id=\'navbarText\']/ul/li[2]/a")
	WebElement useridtext;

	@FindBy(xpath = "//h1[normalize-space()='Dashboard']")
	WebElement dashboardtitle;

	@FindBy(linkText = "Logout")
	WebElement logoutlink;

	@FindBy(xpath = "//p[normalize-space()='Catalog']")
	WebElement sidemenu_Catalog;

	@FindBy(xpath = "//p[normalize-space()='Sales']")
	WebElement sidemenu_Sales;

	@FindBy(xpath = "//p[normalize-space()='Content management']")
	WebElement sidemenu_Cont_mgmnt;

	@FindBy(xpath = "//p[normalize-space()='Customers']")
	WebElement sidemenu_Customers;

	@FindBy(xpath = "//p[normalize-space()='Promotions']")
	WebElement sidemenu_Promotions;

	@FindBy(xpath = "//p[normalize-space()='Configuration']")
	WebElement sidemenu_Confgigutration;

	@FindBy(xpath = "//p[normalize-space()='System']")
	WebElement sidemenu_System;

	@FindBy(xpath = "//p[normalize-space()='Reports']")
	WebElement sidemenu_Reports;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement sideMenu_customer_link;

	@FindBy(xpath = "//p[normalize-space()='Customer roles']")
	WebElement sideMenu_customer_role_link;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getuser() {
		return useridtext;
	}

	public WebElement getdashboardtitle() {
		return dashboardtitle;
	}

	public HomePage clickLogoutlink() {

		logoutlink.click();
		HomePage hp = new HomePage(driver);
		return hp;
	}

	public WebElement getSidemenu_cataglog() {
		return sidemenu_Catalog;
	}

	public WebElement getSidemenu_Sales() {
		return sidemenu_Sales;
	}

	public WebElement getSidemenu_Cont_mgmnt() {
		return sidemenu_Cont_mgmnt;
	}

	public WebElement getSidemenu_Customers() {
		return sidemenu_Customers;
	}

	public WebElement getSidemenu_Promotions() {
		return sidemenu_Promotions;
	}

	public WebElement getSidemenu_Configuration() {
		return sidemenu_Confgigutration;
	}

	public WebElement getSidemenu_System() {
		return sidemenu_System;
	}

	public WebElement getSidemenu_Reports() {
		return sidemenu_Reports;
	}

	public WebElement SideMenu_Customers() {

		return sideMenu_customer_link;
	}

	public WebElement sideMenu_customer_role_link() {
		return sideMenu_customer_role_link;
	}
}
