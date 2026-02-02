package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
			
		driver.findElement(By.linkText("Comments (Atom)")).click();
		Thread.sleep(5000);	
		
		//driver.close();//it will close the current browser window where the driver is focused
		
		driver.quit();//it will close all browser windows 
		
	}

}
