package day6;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//single checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//WebElement sunday = driver.findElement(By.xpath("//input[@id='sunday']"));
		//sunday.click();
		
		//handling multiple check boxes
		
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		//7 check boxes
		/*for(WebElement cb : checkBoxes) {
			cb.click();
		}
		*/
		
		//selecting last 3 three check boxes
		// starting index = total size - number of check boxes from the last
		// starting index = 7 - 3 = 4
		/*for(int i = 4; i < checkBoxes.size(); i++) {
			checkBoxes.get(i).click();
		}
		*/
		
		//selecting first 3 check boxes
		for(int i = 0; i < 3; i++) {
			checkBoxes.get(i).click();
		}
		
		Thread.sleep(3000);
		//unselect the selected check boxes
		for(WebElement ch : checkBoxes) {
			if(ch.isSelected()) {
				ch.click();
			}
		}
	}

}
