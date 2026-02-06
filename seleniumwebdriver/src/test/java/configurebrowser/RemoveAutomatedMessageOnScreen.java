package configurebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RemoveAutomatedMessageOnScreen {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1000,800");//set window size (width, height)
		
		//Disable the "Chrome is being controlled by automated test software"
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.youtube.com/");
		
	}

}
