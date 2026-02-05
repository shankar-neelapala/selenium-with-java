package mouse_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//capture the target element
		WebElement source = driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//System.out.println(source.getLocation());//(779, 1689)
		//System.out.println(target.getLocation());(891, 1681)
		//Actions
		Actions act = new Actions(driver);
		//act.dragAndDrop(source, target).perform();
		
		/*
		int xOffset = target.getLocation().getX() - source.getLocation().getX();
		int yOffset = target.getLocation().getY() - source.getLocation().getY();

		act.dragAndDropBy(source, xOffset, yOffset).perform();
		*/
		
		act.clickAndHold(source).moveToElement(target).release().perform();
	}

}
