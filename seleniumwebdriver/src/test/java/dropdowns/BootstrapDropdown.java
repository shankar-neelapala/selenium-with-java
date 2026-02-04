

package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html#");
		//Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//button[@id='menu1']"));
		element.click();
		
		List<WebElement> optionsEle = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
		System.out.println(optionsEle.size());
		
		for(WebElement option : optionsEle) {
//			if(option.getText().equals("HTML")) {
//				option.click();
//			}
			System.out.println(option.getText());
		}
	}
}
