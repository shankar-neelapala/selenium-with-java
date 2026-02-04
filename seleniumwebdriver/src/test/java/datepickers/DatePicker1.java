package datepickers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dummy-tickets.com/buyticket");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement departureDate = wait.until(
		        ExpectedConditions.presenceOfElementLocated(
		                By.xpath("//form[@id='flight_oneway']//input[@placeholder='Departure Date']")
		        )
		);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// set value directly
		js.executeScript(
		        "arguments[0].value='20 Feb 2020';",
		        departureDate
		);


	}
}
