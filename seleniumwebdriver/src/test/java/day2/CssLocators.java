package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators {
	public static void main(String args[]) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");		

		//driver.manage().window().maximize();// it maximize the window
		
		//tag id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mac");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mac"); // tag is optional
		
		
		//tag class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Windows");
		//tag is optional
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Windows");
		
		//tag attribute
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Linux");
		
		//tag class attribute
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("Gagan");
	
	

	}
}
