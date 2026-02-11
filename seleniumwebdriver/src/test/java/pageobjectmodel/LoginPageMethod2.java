package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageMethod2 {

WebDriver driver;
	
	//Constructor to initialize driver
	LoginPageMethod2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement textUsername;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement textPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	
	
	//actions
	void setUsername(String username) {
		textUsername.sendKeys(username);
	}
	
	void setPassword(String password) {
		textPassword.sendKeys(password);
	}
	
	void clickLoginButton() {
		(loginButton).click();
	}
}
