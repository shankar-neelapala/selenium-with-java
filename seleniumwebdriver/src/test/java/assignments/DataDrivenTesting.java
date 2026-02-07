package assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import datadriventesting.ExcelUtilities;

public class DataDrivenTesting {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		//cookie
		driver.findElement(By.xpath("//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']")).click();
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\cal-data.xlsx";
		String sheetName = "Sheet1";
		
		int rows = ExcelUtilities.getRowsCount(filePath, sheetName);
		for(int i = 1; i <= rows; i++) {
			//reading data from excel file
			String amount = ExcelUtilities.getCellValue(filePath, sheetName, i, 0);
			String length = ExcelUtilities.getCellValue(filePath, sheetName, i, 1);
			String interest = ExcelUtilities.getCellValue(filePath, sheetName, i, 2);
			String compounding = ExcelUtilities.getCellValue(filePath, sheetName, i, 3);
			
			//passing data to the application
			WebElement amountElement = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			amountElement.clear();
			amountElement.sendKeys(amount);
			
			WebElement lengthElement = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			lengthElement.clear();
			lengthElement.sendKeys(length);
			
			WebElement interestElement = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(interestElement)
			       .click()
			       .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			       .sendKeys(Keys.DELETE)
			       .sendKeys(interest)
			       .perform();
			
			driver.findElement(By.xpath("//div[@class='mat-mdc-select-arrow']//*[local-name()='svg']")).click();
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
			        By.xpath("//div//mat-option[@role='option']")));

			for (WebElement option : options) {
			    String text = option.getText().trim();
			    if (text.equals(compounding.trim())) {
			    	//System.out.println(text);
			        option.click();
			        break;
			    }
			}
			wait.until(ExpectedConditions.elementToBeClickable(By.id("CIT-chart-submit"))).click();

			//validation
			String Expectedtotal = ExcelUtilities.getCellValue(filePath, sheetName, i, 4);
			String ActualTotal = driver.findElement(By.xpath("//span[@id='displayTotalValue']")).getText();			
			double actual = Double.parseDouble(ActualTotal.replace("$", "").replace(",", "").trim());
			double expected = Double.parseDouble(Expectedtotal.replace("$", "").replace(",", "").trim());
			if (Double.compare(actual, expected) == 0) {
			    System.out.println("Test Passed..." + actual + " " + expected);
			    ExcelUtilities.setCellValue(filePath, sheetName, i, 6, "Pass");
			} else {
			    System.out.println("Test Failed..." + actual + " " + expected);
			    ExcelUtilities.setCellValue(filePath, sheetName, i, 6, "Fail");
			}
		}
		driver.quit();
	}

}
