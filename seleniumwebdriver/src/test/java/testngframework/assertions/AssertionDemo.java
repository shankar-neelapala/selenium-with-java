package testngframework.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {

	@Test
	void test() {
		String s1 = "Ronaldo";
		
		/*if(s1.equals("Ronaldo")) {
			System.out.println("Test passed");
			//Test passed
			//PASSED: testngframework.assertions.AssertionDemo.test
		}
		else {
			System.out.println("Test failed");
		}*/
		
		/*if(s1.equals("Messi")) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
			//Test failed
			//PASSED: testngframework.assertions.AssertionDemo.test
		}*/
		
		//Assert.assertEquals(s1, "Ronaldo");//passed
		
		Assert.assertEquals(s1, "messi");//failed
	}

}
