package shadowdoms_svg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://books-pwakit.appspot.com/");
		
		//driver.findElement(By.cssSelector("#input")).sendKeys("Ronaldo");//NoSuchElementException
		
		//This Element is inside single shadow DOM.
//		String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
//		Thread.sleep(1000);
		
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		WebElement search = shadow.findElement(By.cssSelector("#input"));
		search.sendKeys("Bible"+ Keys.ENTER);
	}

}
