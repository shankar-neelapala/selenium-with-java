package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		//xpath with single attribute		
		//driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Mac");
		//driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys("Mac");
		
		//xpath with multiple attributes
		driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("MacBook");
	}
}
