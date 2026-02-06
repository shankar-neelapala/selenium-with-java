package screenshots;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullPageScreenshot {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//TakeScreenshot is an interface which provides methods to take screen shots
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		//D:\selenium-with-java\seleniumwebdriver\screenshots
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		src.renameTo(target);//copying src file to target file
	}

}
