package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//page object model without using PageFactory class
public class LoginPageMethod1 {

	WebDriver driver;
	
	//Constructor to initialize driver
	LoginPageMethod1(WebDriver driver){
		this.driver = driver;
	}
	
	//locators	
	By textUsername = By.xpath("//input[@placeholder='Username']");
	By textPassword = By.xpath("//input[@placeholder='Password']");
	By loginButton = By.xpath("//button[@type='submit']");
	
	//actions
	void setUsername(String username) {
		driver.findElement(textUsername).sendKeys(username);
	}
	
	void setPassword(String password) {
		driver.findElement(textPassword).sendKeys(password);
	}
	
	void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
}
