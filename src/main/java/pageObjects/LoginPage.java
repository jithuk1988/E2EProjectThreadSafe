package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(id = "Email")
	WebElement username;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "*//button[contains(text(), 'Log in')]")
	WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getusername() {
		return username;
	}

	public WebElement getpassword() {
		return password;
	}

	public LoginPage clickLogin() {
		
		loginbutton.click();
		LoginPage lp = new LoginPage(driver);
		return lp;
		
	}
}
