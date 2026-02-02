package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//isDisplayed()	validate whether an element is displayed or not
//		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='GUI Elements']"));
//		boolean status = element.isDisplayed();
//		System.out.println(status);//true
		
		//the above lines can written in single line
//		boolean status = driver.findElement(By.xpath("//a[normalize-space()='GUI Elements']")).isDisplayed();
//		System.out.println(status);//true
		
		//isEnabled()	it checks an element is enabled or not 
//		boolean ena = driver.findElement(By.xpath("//input[@placeholder='Enter Name']")).isEnabled();
//		System.out.println(ena);//true
		
		//isSelected() 	it checks elements like drop-down, radio, check-box are selected or not
		WebElement radioMale = driver.findElement(By.xpath("//input[@id='male']"));
		boolean selectStatus = radioMale.isSelected();
		System.out.println(selectStatus);//false	because there are two buttons male and female nothing is selected
		
		//changing male radio button not selected to selected
		radioMale.click();//click() helps to click the web element, here it selects the radio button
		System.out.println(radioMale.isSelected());//true
		
		//changing female radio button not selected to selected
		WebElement radiofemale = driver.findElement(By.xpath("//input[@id='female']"));
		System.out.println(radiofemale.isSelected());//false
		
		radiofemale.click();
		System.out.println(radiofemale.isSelected());//true
	}

}
