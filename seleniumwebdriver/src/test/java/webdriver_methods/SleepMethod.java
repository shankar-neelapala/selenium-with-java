package webdriver_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepMethod {

	public static void main(String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		Thread.sleep(5000);//pause the execution up to specified time
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Ronaldo");
	}
}
