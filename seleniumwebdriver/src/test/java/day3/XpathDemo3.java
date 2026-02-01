package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo3 {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//xpath with contains() method
		//driver.findElement(By.xpath("//input[contains(@placeholder,'store')]")).sendKeys("Mac");
		// placeholder = 'Search store'
		//driver.findElement(By.xpath("//input[contains(@placeholder,'ore')]")).sendKeys("Mac");
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search store')]")).sendKeys("Mac");
		//driver.findElement(By.xpath("//input[contains(@placeholder,'st')]")).sendKeys("Mac");
		
		//xpath with starts-with() method
		//driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Sea')]")).sendKeys("Linux");
		//driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Search s')]")).sendKeys("Linux");
		
		//we can use inner text also text() method
		//driver.findElement(By.xpath("//a[starts-with(text(), 'Apple')]")).click();//Apple MacBook Pro
		driver.findElement(By.xpath("//a[contains(., 'Pro')]")).click();// text() and . are same 
	}
}
