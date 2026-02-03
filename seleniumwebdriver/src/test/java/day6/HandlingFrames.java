package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
//		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
//		driver.switchTo().frame(frame1);//web element
		
		driver.switchTo().frame(0);//index
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Shankar");
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Gagan");
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		driver.switchTo().defaultContent();
	}

}
