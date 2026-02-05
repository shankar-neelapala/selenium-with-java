package mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//capture min and max buttons
		WebElement min = driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
		WebElement max = driver.findElement(By.xpath("//div[@id='HTML7']//span[2]"));
		
		
		//get current location of min and max
		System.out.println(min.getLocation());//(805 2020)
		System.out.println(max.getLocation());//(935, 2020)
		
		
		//its a vertical slider so move min to x-axis by keeping y-axis same
		Actions act = new Actions(driver);
		act.dragAndDropBy(min, 10, 0).perform();
		System.out.println(min.getLocation());//(815, 2020)
		
		act.dragAndDropBy(max, 50, 0).perform();
//		act.clickAndHold(max)
//		   .moveByOffset(20, 0)
//		   .release()
//		   .perform();
		System.out.println(max.getLocation());//(984, 2020)
	}

}
