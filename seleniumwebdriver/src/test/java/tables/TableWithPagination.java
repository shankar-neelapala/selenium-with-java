package tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableWithPagination {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//rows
		int rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
		//columns
		int cols = driver.findElements(By.xpath("//table[@id='productTable']/thead//th")).size();
		
		//if the price of the product is greater than 10 dollars then select the check box
		//below logic select check box on only first page of the table
		/*for(int r = 1; r <= rows; r++) {
			String text = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[3]")).getText();
			Double price = Double.parseDouble(text.replace("$", "").trim());
			if(price > 10.0) {
				driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[4]/input")).click();
			}
		}
		*/
		
		//select check box if price greater then 10 dollars for all pages
		//count number of pages
		int pages = driver.findElements(By.xpath("//ul[@class='pagination']//li")).size();
		for(int i = 1; i <= pages; i++) {
			for(int r = 1; r <= rows; r++) {
				String text = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[3]")).getText();
				Double price = Double.parseDouble(text.replace("$", "").trim());
				if(price > 10.0) {
					driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+r+"]/td[4]/input")).click();
				}
			}
			Thread.sleep(3000);
			if((i+1) <= pages) {
				driver.findElement(By.xpath("//ul[@class='pagination']//a[text()="+(i+1)+"]")).click();
			}
		}
	}

}
