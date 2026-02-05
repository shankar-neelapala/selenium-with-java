package keyboard_shortcuts;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver switched to the new window
		System.out.println(driver.getCurrentUrl());//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Messi");
		
		//switch driver to default window
		//driver.switchTo().defaultContent(); it won't work becuase with in the browser window only we can switch
		System.out.println(driver.getCurrentUrl());//https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		//System.out.println(driver.getWindowHandles());
		//get window ID's
		Set<String> ids = driver.getWindowHandles();
		for(String id : ids) {
			//Thread.sleep(3000);
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/")) {
				break;
			}
		}
		driver.findElement(By.xpath("//a[@role='button'][normalize-space()='Books']")).click();
	}

}
