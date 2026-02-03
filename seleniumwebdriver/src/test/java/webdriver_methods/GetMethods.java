package webdriver_methods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	
	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		//get() it will launch specified url on the browser
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//getTitle()	returns title of the page
		//System.out.println(driver.getTitle());//Automation Testing Practice
		
		//getCurrentUrl()	returns the current page url
		//System.out.println(driver.getCurrentUrl());//https://testautomationpractice.blogspot.com/
		
		
		//getClass()	returns the type of the instance
		System.out.println(driver.getClass());//class org.openqa.selenium.chrome.ChromeDriver

		//getWindowHandle()	returns the ID of the single browser window
		String ab = driver.getWindowHandle();//1C63C465136CCABE92703A49BB910C21
		System.out.println(ab);
		
		//getWindowHandles()	return the ID's of multiple browser windows
		driver.findElement(By.linkText("Comments (Atom)")).click();
		Set<String> cd = driver.getWindowHandles();
		System.out.println(cd);//[1C63C465136CCABE92703A49BB910C21, 6C5CE439C25E71402DD38F3ECD6977FE]
	}
}
