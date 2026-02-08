package testngframework.assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	@Test
	void soft() {
		System.out.println("step1");
		System.out.println("step2");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("abc", "xyz");
		
		System.out.println("step3");
		System.out.println("step4");
		/*
		 * 	output
		 * 	step1
			step2
			step3
			step4
			PASSED: testngframework.assertions.SoftAssertion.soft
			because test will PASS even with failures 
			do not forget assertAll() method 
		 */
		sa.assertAll();
		/*
		 * after calling assertAll() method
		 * 	step1
			step2
			step3
			step4
			FAILED: testngframework.assertions.SoftAssertion.soft
		 */
	}
}
