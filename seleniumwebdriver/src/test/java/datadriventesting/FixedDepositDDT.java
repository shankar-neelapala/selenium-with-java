package datadriventesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * step1: functionality of the test case(like steps)
 * step2: prepare your test data
 * step3: develop automated test script
 */
import org.openqa.selenium.support.ui.Select;

public class FixedDepositDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		String filePath = System.getProperty("user.dir")+"\\testdata\\fd-data.xlsx";
		String sheetName = "Sheet1";
		
		//get number of rows in excel file
		int rows = ExcelUtilities.getRowsCount(filePath, sheetName);
		System.out.println(rows);

		//iterate through each row (run test case against all test data)
		for(int i = 1; i <= rows; i++) {
			
			//get the data from excel file
			String amount = ExcelUtilities.getCellValue(filePath, sheetName, i, 0);
			String rateOfInterest = ExcelUtilities.getCellValue(filePath, sheetName, i, 1);
			String period1 = ExcelUtilities.getCellValue(filePath, sheetName, i, 2);
			String period2 = ExcelUtilities.getCellValue(filePath, sheetName, i, 3);
			String frequency = ExcelUtilities.getCellValue(filePath, sheetName, i, 4);
			String ExpectedMaturityValue = ExcelUtilities.getCellValue(filePath, sheetName, i, 5);
			
			//pass data to the application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(amount);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			Select tendrp = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			tendrp.selectByVisibleText(period2);
			Select freqdrp = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			freqdrp.selectByVisibleText(frequency);			
			//clicked on calculate button
			driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]")).click();
			
			//validtion
			String ActualMaturityValue = driver.findElement(By.xpath("//span[@class='gL_27']//strong")).getText();
			if(Double.parseDouble(ExpectedMaturityValue) == Double.parseDouble(ActualMaturityValue)) {
				System.out.println("Test Passed....");
				ExcelUtilities.setCellValue(filePath, sheetName, i, 7, "pass");
				//ExcelUtilities.fillGreenColor(filePath, sheetName, i, 7);
			}
			else {
				System.out.println("Test Failed...");
				ExcelUtilities.setCellValue(filePath, sheetName, i, 7, "fail");
				//ExcelUtilities.fillRedColor(filePath, sheetName, i, 7);
			}
			//clear the data
			Thread.sleep(1000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
