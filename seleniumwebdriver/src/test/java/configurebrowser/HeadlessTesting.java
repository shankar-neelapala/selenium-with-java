package configurebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		//create object for chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");//--headless=new is set to perform testing headless

		//1. Launch browser
		WebDriver driver = new ChromeDriver(options);
		
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
		
		driver.quit();
	}

}
