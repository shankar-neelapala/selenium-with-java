package datepickers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	static void selectPastMonthAndYear(WebDriver driver, String expYear, String expMonth, String expDate) {
	
		//selecting month and year
		while(true) {
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(currentMonth.toLowerCase().equals(expMonth) && currentYear.equals(expYear)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		//selecting date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//*[text()="+expDate+"]")).click();
	}
	
	static void selectFutureMonthAndYear(WebDriver driver, String expYear, String expMonth, String expDate) {
		
		//selecting month and year
		while(true) {
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			if(currentMonth.toLowerCase().equals(expMonth) && currentYear.equals(expYear)) {
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//selecting date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//*[text()="+expDate+"]")).click();
	}
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https:jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//click on date picker
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//expected year
		String expYear = "2026";
		//expected month
		String expMonth = "may";
		//expected date
		String expDate = "17";
		//past date picker
		//selectPastMonthAndYear(driver, expYear, expMonth,expDate);
		
		//future date picker
		selectFutureMonthAndYear(driver, expYear, expMonth, expDate);
		
	}

}
