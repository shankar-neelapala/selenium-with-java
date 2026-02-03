package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo1 {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//xpath with and operator
		// and operator is used when all attributed and ANDed together, all conditions are satisfied
		
		//driver.findElement(By.xpath("//input[@id='small-searchterms' and @placeholder='Search store']")).sendKeys("windows");
		// the above and below two syntaxes are same. They perform same operation i.e, AND
		//driver.findElement(By.xpath("//input[@id='small-searchterms'][@placeholder='Search store']")).sendKeys("MacBook");
	
		//xpath with or operator
		// or operator is used when at least one condition is true
		//at least one attribute is matched then it find the element
		driver.findElement(By.xpath("//input[@id='small-searchterms' or @placeholder='Sch store']")).sendKeys("windows");

		//driver.quit();
	}
}
