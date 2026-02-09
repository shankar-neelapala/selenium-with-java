package testngframework.listeners;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListenersDemo {

	private WebDriver driver;
	
	@BeforeClass
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	@Test(priority = 1)
	void testTitle() {
		String title = "Automation Testing Practice";
		Assert.assertEquals(title, driver.getTitle());
	}
	
	@Test(priority = 2)
	void testUrl() {
		String exp = "https://testautomationpractice.blogspot.com/index";
		Assert.assertEquals(exp, driver.getCurrentUrl());
	}
	
	@Test(dependsOnMethods = {"testUrl"})
	void refreshPage() {
		driver.navigate().refresh();
	}
	
	@AfterClass
	void closeApp() {
		driver.quit();
	}
}
