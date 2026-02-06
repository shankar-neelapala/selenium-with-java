package configurebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");//maximize the window
		//options.setAcceptInsecureCerts(true);//accpets ssl certificates
		options.addArguments("--ignore-certificate-errors");
		
		WebDriver driver = new ChromeDriver(options);		
		//driver.manage().window().maximize();
				
		driver.get("https://expired.badssl.com/");
		
	}

}
