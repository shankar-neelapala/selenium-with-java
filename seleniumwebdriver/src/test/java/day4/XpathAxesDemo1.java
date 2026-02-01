package day4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		
		//child::
		//driver.findElement(By.xpath("//a[contains(@title, 'Show products')]/child::img")).click();
		//driver.findElement(By.xpath("//a[contains(@title, 'Show products')]/img")).click();
		
		//grand child
		//driver.findElement(By.xpath("//div[contains(@class, 'pic')]/a/img")).click();
		//driver.findElement(By.xpath("//div[contains(@class, 'pic')]//img")).click();
		//driver.findElement(By.xpath("//div[contains(@class, 'pic')]/*/img")).click();
		
		
		
		//descendant::
		//List<WebElement> des = driver.findElements(By.xpath("//article[contains(@class, 'item')]/descendant::*"));
		//System.out.println(des.size());
				
		//there are so many <a> under current node but it will take first one, if you want 2 or 3 then specify with index a[2]
		//driver.findElement(By.xpath("//article[contains(@class, 'item')]/descendant::a")).click();
		WebElement article = driver.findElement(By.xpath("//article[contains(@class, 'item')]/descendant::*"));
		article.findElement(By.xpath(".//a")).click();
		
		
	}

}
