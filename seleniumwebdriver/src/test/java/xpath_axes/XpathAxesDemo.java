package xpath_axes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		
		//self axes (self::)
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]/self::input")).sendKeys("Self");
		
		//without self:: its a relative xpath (nothing special)
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys("Self");
		
		
		//parent::
		//driver.findElement(By.xpath("//img[contains(@title,'Show products')]/parent::a")).click();// immediate parent of img is a
		
		//ancestor::
		String text = driver.findElement(By.xpath("//img[contains(@title,'Show products')]/ancestor::div")).getText();
		System.out.println(text);
		
		
	}
}
