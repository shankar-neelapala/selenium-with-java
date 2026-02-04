package tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		 if there is only one table in the page then use tagname to identify the element
		 otherwise use xpath
		 */
		//number of rows
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		//number of columns
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		//int columns = driver.findElements(By.tagName("th")).size();
		//print the table
		/*for(int r = 2; r <= rows; r++) {
			for(int c = 1; c <= columns; c++) {
				String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(data+"\t");
			}
			System.out.println();
		}*/
		
		//print the books whose author is mukesh
		for(int r = 2; r <= rows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(author.equals("Mukesh")) {
				String book = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.print(book+"\t"+author);
			}
			System.out.println();
		}
		
		//calculate the total price of all books
		int total = 0;
		for(int r = 2; r <= rows; r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			total += Integer.parseInt(price);
		}
		System.out.println("Total price: "+total);
		
	}

}
