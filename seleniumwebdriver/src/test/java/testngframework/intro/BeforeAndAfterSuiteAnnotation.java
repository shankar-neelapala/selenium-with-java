package testngframework.intro;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAndAfterSuiteAnnotation {

	@BeforeSuite
	void bf() {
		System.out.println("Before suite...");
	}
	
	@AfterSuite
	void af() {
		System.out.println("After suite...");
	}
	
	@Test
	void test() {
		System.out.println("Suite Testcase...");
	}
}
