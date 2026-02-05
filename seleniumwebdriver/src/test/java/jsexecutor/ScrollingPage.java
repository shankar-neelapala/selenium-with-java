package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//scrolling up to specified pixels
		//js.executeScript("window.scrollBy(0, 1500)");
		//System.out.println(js.executeScript("return window.pageYOffset")));//1500.3115234375
		
		//scroll up to particular element
		/*WebElement element = driver.findElement(By.xpath("//a[@class='home-link']"));
		js.executeScript("arguments[0].scrollIntoView()", element);
		System.out.println(js.executeScript("return window.pageYOffset"));
		*/
		
		//scroll till the end of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset"));//3521.495361328125
		
		//scroll back 
		js.executeScript("window.scrollBy(0, -500)");
		//js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");// scroll back to inital
	}

}
