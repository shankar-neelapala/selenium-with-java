package configurebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunTestIncognitoMode {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		//1. Launch browser
		WebDriver driver = new ChromeDriver(options);
		
		// 2. Go to https://www.youtube.com/ page
		driver.get("https://www.youtube.com/");
		
		//3. Validate page title with "YouTube"
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("YouTube")) {
			System.out.println("Test Passed...");
		}
		else {
			System.out.println("Test Failed!!!");
		}
		
		driver.quit();
	}

}
