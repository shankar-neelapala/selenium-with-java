package testngframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/*
 * 1. open application 
 * 2. login into the application
 * 3. logout from the application
 * 4. close application
 */

public class OrangeHRMTest {
  
	private WebDriver driver;
	
	@Test(priority = 1)
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(priority = 2)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
//	@Test(priority = 3)
//	void logout() {
//		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
//	}
	
	@Test(priority = 4)
	void closeApp() {
		driver.quit();
	}
}
