package testngframework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo implements ITestListener{

	private ExtentSparkReporter spark;//UI of the report
	private ExtentReports report;//populate common info on report
	private ExtentTest test;//creating test case entries in the report and update status of the test methods
	
	@Override
	public void onStart(ITestContext context) {
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		
		spark.config().setDocumentTitle("Automation Testing Report");
		spark.config().setReportName("Sanity Testing");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("Computer", "localhost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("OS","Windows10");
		report.setSystemInfo("Browser", "Chrome");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());//create a new entry in the report
		test.log(Status.PASS, "Test case passed : "+result.getName());//update status 
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test case failed : "+result.getName()+"\n"+result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped : "+result.getName()+" "+result.getSkipCausedBy());
	}
	
	//mandatory
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
}
