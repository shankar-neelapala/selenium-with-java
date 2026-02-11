package pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	
	@BeforeClass
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	void login() {
		//LoginPageMethod1 lp = new LoginPageMethod1(driver);
		LoginPageMethod2 lp = new LoginPageMethod2(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.clickLoginButton();
		
		//validation
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void closeApp() {
		driver.quit();
	}
}
