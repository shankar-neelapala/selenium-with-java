package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 1. Launch browser
 2. Go to https://www.youtube.com/ page
 3. Validate page title with "YouTube"
 4. Close browser
 */
public class FirstTestCase {

	public static void main(String[] args) {
		
		//1. Launch browser
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		// 2. Go to https://www.youtube.com/ page
		driver.get("https://www.youtube.com/");//get() method used to load the page in the browser
		
		//3. Validate page title with "YouTube"
		String actualTitle = driver.getTitle();//return title of the page
		
		if(actualTitle.equals("YouTube")) {
			System.out.println("Test Passed...");
		}
		else {
			System.out.println("Test Failed!!!");
		}
		
		
		// 4. Close browser
		//driver.close();
		driver.quit();
	}

}
