package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement countryEle = driver.findElement(By.xpath("//select[@id='country']"));
		Select country = new Select(countryEle);
		
		//selecting by using text
		//country.selectByVisibleText("France");
		
		//by using value of the attribute
		//country.selectByValue("japan");
		
		//index
		country.selectByIndex(2);
	}

}
