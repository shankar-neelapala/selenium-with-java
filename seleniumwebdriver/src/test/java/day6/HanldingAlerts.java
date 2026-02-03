package day6;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HanldingAlerts {

	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");		
		driver.manage().window().maximize();
		/*
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();		
		//handling normal alert "OK button"
		Alert myalert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		System.out.println(myalert.getText());
		myalert.accept();		//it accepts the alert msg
		*/
		
		/*
		//handling confirmationalert , Ok and Cancel button
		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();	
		Alert confirmALert = driver.switchTo().alert();
		Thread.sleep(3000);
		
		//confirmALert.accept();
		confirmALert.dismiss();
		*/
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//handling prompt alert
		//switching driver to alert with switchTo() method
		//by using explicit wait
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Alert myalert = wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(3000);
		
		myalert.sendKeys("Ronaldo");
		myalert.accept();
	}
}
