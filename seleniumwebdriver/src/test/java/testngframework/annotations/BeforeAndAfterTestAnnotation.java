package testngframework.annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAndAfterTestAnnotation {

	@BeforeTest
	void bf() {
		System.out.println("Before test...");
	}
	
	@AfterTest
	void af() {
		System.out.println("After test...");
	}
	
	@Test
	void test() {
		System.out.println("Test Testcase...");
	}
}
