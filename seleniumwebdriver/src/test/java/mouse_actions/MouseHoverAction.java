package mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//capturing the web element 
		WebElement computers = driver.findElement(By.xpath("//a[normalize-space()='Computers']"));
		//Actions class
		Actions act = new Actions(driver);
		//moveToElement(webelement) is used to perform mouse hover action
		act.moveToElement(computers).build().perform();
		//act.clickAndHold(computers).perform();
		
		WebElement desktops = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		//act.moveToElement(desktops).click().perform();
		//act.click(desktops).perform();
		
		Action myact = act.moveToElement(desktops).click().build();
		myact.perform();
		
	}

}
