package testngframework.intro;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAndAfterClassAnnotation {

	@BeforeClass
	void bf() {
		System.out.println("Before class...");
	}
	
	@AfterClass
	void af() {
		System.out.println("After class...");
	}
	
	@Test
	void test1() {
		System.out.println("Class Test Case...1");
	}
	
	@Test
	void test2() {
		System.out.println("Clss Test case...2");
	}
}
