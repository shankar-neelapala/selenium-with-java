package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollingDropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Select an item']")).click();
		
		String option = "Item 96";
		WebElement item = driver.findElement(By.xpath("//div[.='"+option+"']"));
		
//		Actions act = new Actions(driver);
//		act.scrollToElement(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[.='"+option+"']"))))
//			.pause(Duration.ofSeconds(3))
//			.click()
//			.perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				//"arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});"+
				"arguments[0].click()", item);
	}

}
