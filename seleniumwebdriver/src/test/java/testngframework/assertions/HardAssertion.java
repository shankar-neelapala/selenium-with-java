package testngframework.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

	@Test
	void hard() {
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(20, "20");
		/* output
		step1
		step2
		FAILED: testngframework.assertions.HardAssertion.hard*/
		
		//these statements never executes
		System.out.println("step3");
		System.out.println("step4");
	}
}
