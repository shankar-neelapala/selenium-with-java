package wait_strategies;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		
		//declaration
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))//maximum wait time
				.pollingEvery(Duration.ofSeconds(5))//polling time
				.ignoring(NoSuchElementException.class);//exception to ignore
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				
		WebElement username = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		
//		WebElement username = mywait.until(new Function<WebDriver, WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.xpath("//input[@placeholder='Username']"));
//			}
//		});
//		
		username.sendKeys("Neymar");
	}
}
