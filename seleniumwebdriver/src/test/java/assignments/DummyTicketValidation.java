package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DummyTicketValidation {
	
	static void datePicker(WebDriver driver, String year, String month, String date) {
		//selecting month
		Select m = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
		m.selectByVisibleText(month);
		//selecting year
		Select y = new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
		y.selectByVisibleText(year);
		//date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[.="+date+"]")).click();				
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		//visa application
		List<WebElement> li = driver.findElements(
		        By.xpath("//div[@id='opc-product-selection']//li"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < li.size(); i++) {
		    if (li.get(i).getText().contains("Visa Application")) {

		        WebElement radio = driver.findElement(
		                By.xpath("//ul[@id='checkout-products']//li[" + (i + 1) + "]//input"));
		        js.executeScript("arguments[0].scrollIntoView(true);", radio);
		        js.executeScript("arguments[0].click();", radio);
		        break;
		    }
		}
		
		//username
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Ronaldo");
		//surname
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys("Goat");
		
		//dob
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		datePicker(driver, "1985", "Feb", "5");
		Thread.sleep(3000);
		
		//sex
		driver.findElement(By.xpath("//input[@id='sex_1']")).click();
		
		//from
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Delhi");
		//to
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Mumbai");
		//departure
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		datePicker(driver, "2026", "Mar", "17");
		Thread.sleep(3000);
		
		//phone number
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("4567890");
		
		//email
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("ronaldo7@gmail.com");
		
		//address
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("Bhimavaram");
		
		//state
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("akividu");
		
		//select state drop down
		driver.findElement(By.xpath("//span[@id='select2-billing_state-container']")).click();
		List<WebElement> states = driver.findElements(By.xpath("//span[@class='select2-results']//li"));
		for(WebElement state : states) {
			if(state.getText().contains("Andhra")) {
				state.click();
				break;
			}
		}
		
		//pin code
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("123456");
		
		//place order
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='place_order']")).click();
	}

}
