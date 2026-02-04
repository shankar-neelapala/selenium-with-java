package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FlightTicketConfirmatiion {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//selecting departure city
		WebElement departureElement = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departure = new Select(departureElement);
		List<WebElement> departureCities = departure.getOptions();
		for(WebElement city : departureCities) {
			if(city.getText().equals("Boston")){
				city.click();
				break;
			}
		}
		
		//selecting destination city
		WebElement destinationElement = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destination = new Select(destinationElement);
		List<WebElement> destinationCities = destination.getOptions();
		for(WebElement city : destinationCities) {
			if(city.getText().equals("London")){
				city.click();
				break;
			}
		}
		
		//click on find flights
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		//choosing the flight
		int rows = driver.findElements(By.xpath("//tbody//tr")).size();
		//int cols = driver.findElements(By.xpath("//thead//th")).size();
		String lowPrice = driver.findElement(By.xpath("//tbody//tr[1]//td[6]")).getText();
		WebElement choice = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		for(int r = 1; r <= rows; r++) {
			String price = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[6]")).getText();
			//System.out.println(price);
			if(price.compareTo(lowPrice) < 0) {
				//System.out.println(lowPrice);
				lowPrice = price;
				choice = driver.findElement(By.xpath("//tbody//tr["+r+"]//td[1]"));
			}
		}
		System.out.println("Ticket Price : "+lowPrice);
		//click to choose the flight
		choice.click();
		
		
		//submitting the form
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Cristiano Ronaldo");//name
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Portugal");//address
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Quinta da Marinha, Cascais.");//city
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Lisbon");//state
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("12345");//pin code
		driver.findElement(By.xpath("//label[@class='checkbox']")).click();
		//purchase ticker
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		//validating the ticket confirmation
		String text = driver.findElement(By.xpath("//h1")).getText();
		if(text.contains("Thank you")) {
			System.out.println("Ticket has booked!");
		}
		else {
			System.out.println("Ticket has not booked");
		}
	}

}
