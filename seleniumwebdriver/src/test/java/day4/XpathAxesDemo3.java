package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		
		//preceding::
		//List<WebElement> a = driver.findElements(By.xpath("//a[@class='ico-cart']/preceding::a"));
		//System.out.println(a.size());
		
		//driver.findElement(By.xpath("//a[@class='ico-cart']/preceding::a[1]")).click();
		
		
		//preceding-sibling::
		driver.findElement(By.xpath("//span[@class='cart-qty']/preceding-sibling::span")).click();
	}

}
