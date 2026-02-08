package testngframework.annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAndAfterMethodAnnotation {

	@BeforeMethod
	void bf() {
		System.out.println("Before method...");
	}
	
	@AfterMethod
	void af() {
		System.out.println("After method...");
	}
	
	@Test
	void test() {
		System.out.println("Method Test Case...");
	}
}
