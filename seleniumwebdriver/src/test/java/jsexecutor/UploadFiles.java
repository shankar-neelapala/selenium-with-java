package jsexecutor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFiles {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		/*
		WebElement singleFile = driver.findElement(By.xpath("//input[@id='singleFileInput']"));
		singleFile.sendKeys("D:\\mccp\\mccp1\\Anagram2.java");
		//validation
		driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@id='singleFileStatus']")).getText());
		*/
		
		//paths of files
		String file1 = "D:\\mccp\\mccp1\\Anagram2.java";
		String file2 = "D:\\mccp\\mccp1\\Anagram3.java";
		WebElement multipleFiles = driver.findElement(By.xpath("//input[@id='multipleFilesInput']"));
		multipleFiles.sendKeys(file1+"\n"+file2);
		
		//validation
		driver.findElement(By.xpath("//button[normalize-space()='Upload Multiple Files']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@id='multipleFilesStatus']")).getText());
		
	}

}
