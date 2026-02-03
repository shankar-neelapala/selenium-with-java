package webdriver_methods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		search.sendKeys("Neymar");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(5000);
		
//		List<WebElement> links = driver.findElements(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']/following::a"));
//		System.out.println(links.size());
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Neymar']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Neymar (film)']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Neymargate']")).click();
		
		Set<String> windowId = driver.getWindowHandles();
		System.out.println(windowId);
		
		for(String id : windowId) {
			driver.switchTo().window(id);//switch to another browser window
			if(driver.getTitle().equals("Neymar - Wikipedia")) {
				driver.close();//based on specific id we can close the window
			}
		}
//		Thread.sleep(5000);
//		driver.close();
	}

}
