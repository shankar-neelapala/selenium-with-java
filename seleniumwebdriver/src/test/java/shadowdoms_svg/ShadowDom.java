package shadowdoms_svg;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://dev.automationtesting.in/shadow-dom");
		
		
		//This Element is inside single shadow DOM.
		/*SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		String text1 = shadow.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(text1);//Shadow Element*/
		
		//This Element is inside 2 nested shadow DOM.
		//String cssSelectorForHost1 = "#shadow-root";
		//String cssSelectorForHost2 = "#inner-shadow-dom";
		
		/*SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String text = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(text);//Nested Shadow Element*/
		
		
		//This Element is inside 3 nested shadow DOM.
		//String cssSelectorForHost1 = "#shadow-root";
		//String cssSelectorForHost2 = "#inner-shadow-dom";
		//String cssSelectorForHost3 = "#nested-shadow-dom";
		
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow2 = shadow1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String text = shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		System.out.println(text);//Multi-nested Shadow Element
	}

}
