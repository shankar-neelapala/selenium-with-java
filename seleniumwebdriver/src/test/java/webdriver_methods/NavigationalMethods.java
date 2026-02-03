package webdriver_methods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalMethods {
	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		//get() and navigate.to() both are same
		driver.navigate().to("https://www.pavanonlinetrainings.com/p/udemy-courses.html");
		
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();//reload the page
	}
}
