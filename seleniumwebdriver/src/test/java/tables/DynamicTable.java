package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> headings = driver.findElements(By.xpath("//table[@id='taskTable']//thead//th"));
		System.out.println("Table Headings");
		for(WebElement head : headings) {
			System.out.print(head.getText()+"\t|\t");
		}
		System.out.println();
		//rows
		int rows = driver.findElements(By.xpath("//table[@id='taskTable']//tbody/tr")).size();
		//columns
		int cols = headings.size();
		//reading data from the dynamic table
		for(int r = 1; r <= rows; r++) {
			for(int c = 1; c <= cols; c++) {
				String data = driver.findElement(By.xpath("//table[@id='taskTable']//tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(data+"\t|\t");
			}
			System.out.println();
		}
	}

}
