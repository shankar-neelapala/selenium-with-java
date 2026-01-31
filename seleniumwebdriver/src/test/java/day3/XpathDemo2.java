package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		// xpath with text() inner text
		//driver.findElement(By.xpath("//a[text()='Apple MacBook Pro']")).click();
		
		boolean status = driver.findElement(By.xpath("//h2[text()='Featured products']")).isDisplayed();
		System.out.println(status);
		
		//getText() returns the text value of the element
		String value = driver.findElement(By.xpath("//h2[text()='Featured products']")).getText();
		System.out.println(value);
		
		
		driver.quit();
	}

}
