package keyboard_shortcuts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTab {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		
		//it clicks the link and opens in the same tab
		//overrides the existing url
		//driver.findElement(By.xpath("//a[normalize-space()='Books']")).click();
		
		//open in another tab
		//ctrl + click = opens in another tab
		
		//method 1
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://demo.nopcommerce.com/books");
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Ronaldooo");	
		
		/* method 2
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='Books']"));		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
				
		//driver is still focusing on the defualt browser window
		//switch the driver		
		List<String> windows = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Ronaldooo");	
		*/		
	}

}
