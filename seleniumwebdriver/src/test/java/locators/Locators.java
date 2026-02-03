package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://portfolio-one-gules-68.vercel.app/");
		//driver.get("https://youtube.com/");
		
		
		//driver.manage().window().fullscreen();
		
		//name
		//driver.findElement(By.name("search_query")).sendKeys("Mac");
		
		
		//id
		//WebElement element = driver.findElement(By.id("guide-button"));
		//System.out.println(element);
		//System.out.println(status);
		
		
		//link text
		//driver.findElement(By.linkText("About me")).click();
		
		
		//partial link text
		//driver.findElement(By.partialLinkText("About")).click();
		
		
		
		
		//tagname
		//List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("Total links in the page are "+links.size());
		
		//class
		List<WebElement> total = driver.findElements(By.className("link-cls"));
		System.out.println("Total links with \"link-cls\" are "+total.size());
		
		driver.quit();
	}
}
