package keyboard_shortcuts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardShortcuts {

	public static void main(String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://text-compare.com/");
		
		WebElement text1 = driver.findElement(By.xpath("//textarea[@name='text1']"));
		text1.sendKeys("Ronaldooooooo");
		
		//Actions 
		Actions act = new Actions(driver);
		
		//ctrl + A = select all
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		//ctrl + C == copy
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		//tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		//ctrl + V = paste
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		//compare two strings
		driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
	}
}
