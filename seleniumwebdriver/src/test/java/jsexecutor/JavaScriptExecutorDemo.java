package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Ronaldo");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;// if you directly creating an object for chrome driver then you don't need to up cast the driver
		//instead using sendKeys() using setAttribute()
		js.executeScript("arguments[0].setAttribute('value','Ronaldoo')", name);
		
		System.out.println(driver.findElement(By.xpath("//input[@id='name']")).getAttribute("value"));
		
		//click()
		WebElement radiobtn = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn);
	}

}
