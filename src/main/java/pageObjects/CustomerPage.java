package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	public WebDriver driver;

	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement textbox_email_search;
	@FindBy(xpath = "//input[@id='SearchFirstName']")
	WebElement textbox_firstName_search;
	@FindBy(xpath = "//input[@id='SearchLastName']")
	WebElement textbox_lastName_search;

	
	@FindBy(xpath = "//input[@id='SearchCompany']")
	WebElement textbox_company_search;

	@FindBy(xpath = "//input[@id='SearchIpAddress']")
	WebElement textbox_ipAddress_search;
	
	@FindBy(xpath = "//div[@role='listbox']")
	WebElement listbox_cust_role;

	@FindBy(xpath = "//select[@id='SearchMonthOfBirth']")
	WebElement listbox_dob_month;
	
	@FindBy(xpath = "//select[@id='SearchDayOfBirth']")
	WebElement listbox_dob_year;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement button_search;
	
	@FindBy(xpath="//td[normalize-space()='james_pan@nopCommerce.com']")
	WebElement search_email_result;

	@FindBy(xpath="//td[normalize-space()='Arthur Holmes']")
	WebElement search_firstName_result;
	
		@FindBy(xpath="//div[@id='customers-grid_info']")
	WebElement grid_result_info;
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement get_textbox_email_search() {
		return textbox_email_search;
	}

	public WebElement get_textbox_firstName_serarch() {
		return textbox_firstName_search;
	}	
	
	public WebElement get_textbox_lastName_serarch() {
		return textbox_lastName_search;
	}	
	
	public WebElement get_textbox_IpAddress_serarch() {
		return textbox_ipAddress_search;
	}	
	public WebElement get_listbox_cust_role() {
		return listbox_cust_role;
	}	
	
	public WebElement get_listbox_dob_month() {
		return listbox_dob_month;
	}	
	
	public WebElement get_listbox_dob_year() {
		return listbox_dob_year;
	}	
	
	public WebElement get_search_button() {
		return button_search;
	}	
	public WebElement get_search_email_result() {
		return search_email_result;
	}		
	public WebElement get_grid_result_info() {
		return grid_result_info;
	}	
	public WebElement get_search_firstName_result() {
		return search_firstName_result;
	}	
}
