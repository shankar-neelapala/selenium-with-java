package assignments;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * What is broken link?
 * A broken link, also known as a "dead link," is a hyperlink on a web page that no longer functions,
 * directing users to a non-existent web page or resource.(400 bad request, 404 page not found etc)
 *  
 *  1. Link href="https://abc.com"
 *  2. hit the link to the server and capture response/status code
 *  3. if status code >= 400 then it is a broken link
 *  4. else (<400) not a broken link 
 *  
 */

public class BrokenLinks {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		
		//get all links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: "+links.size());//48
		int brokenLinks = 0;
		
		for(WebElement link : links) {
			
			String hrefValue = link.getAttribute("href");
			if(hrefValue == null || hrefValue.isEmpty()) {
				System.out.println("Not a link...");
				continue;
			}
			
			try {
				URL hrefUrl = new URL(hrefValue);//convert string to url object
				HttpURLConnection con = (HttpURLConnection) hrefUrl.openConnection();//open connection to the server
				con.connect();//hit the url to the server
				
				if(con.getResponseCode() >= 400) {
					brokenLinks++;
					System.out.println(hrefUrl+"	"+con.getResponseCode()+"	"+"Broken Link");
				}
				else {
					System.out.println(hrefUrl+"	"+con.getResponseCode()+"	"+"Working Link");
				}
			}
			catch(Exception e) {}
		}
		
		System.out.println("Total broken link: "+brokenLinks);//42
	}

}
