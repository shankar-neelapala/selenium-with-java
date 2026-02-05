package mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		field1.clear();//clear the existing text
		field1.sendKeys("Cristiano Ronaldo");

		//capture the double click button
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//Actions
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		
		
		if(field1.getAttribute("value").equals("Cristiano Ronaldo")) {
			//field1.getText().equals("Cristiano Ronaldo")
			//getText() method captures only inner text of the element 
			//field1 and field2 haven't any inner text so its retuns null
			//they have value attributes so use getAttribute() to get the value
			System.out.println("Text Copied...");
		}
		else {
			System.out.println("Text not copied!!!");
		}
	}

}
