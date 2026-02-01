package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		
		//following::
		//List<WebElement> f = driver.findElements(By.xpath("//section[contains(@class, 'category-grid')]/following::*"));
		//System.out.println(f.size());
		
		driver.findElement(By.xpath("//section[contains(@class, 'category-grid')]/following::a[1]")).click();
	}

}
