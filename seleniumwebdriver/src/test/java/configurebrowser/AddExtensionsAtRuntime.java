package configurebrowser;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensionsAtRuntime {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption(
		    "excludeSwitches",
		    new String[]{"enable-automation"}
		);

		// IMPORTANT: use addArguments, not addExtensions
		options.addArguments(
		    "--load-extension=C:\\Users\\neela\\Downloads\\SelectorsHub-Chrome-Web-Store"
		);

		//options.addExtensions(new File("C:\\Users\\neela\\Downloads\\SelectorsHub-Chrome-Web-Store.crx"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://text-compare.com");

	}

}
