package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo4 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		//chained xpath
		/*
		 	<div class="header-logo">
				<a href="https://abc.com/"> 
					<img src="https://xyz.com"/>
				</a>
			</div>
		 */
		
		boolean status = driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
		System.out.println(status);
		
		driver.close();
	}

}
