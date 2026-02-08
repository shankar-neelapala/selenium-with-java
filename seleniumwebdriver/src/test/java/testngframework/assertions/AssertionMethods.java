package testngframework.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionMethods {

	@Test
	void methods() {
		
		//Assert.assertEquals(true, true);//pass
		//Assert.assertEquals("abc","ac");//fail
		//Assert.assertEquals(100, 100.02);//fail
		//Assert.assertEquals(12, 12);//pass
		
		//Assert.assertNotEquals("ronaldo", "Messi");//pass
		//Assert.assertNotEquals(5, "5");//pass
		//Assert.assertNotEquals(true, false);//pass
		
		//int a[] = {1, 2, 3};
		//int b[] = {1, 2, 4};
		//Assert.assertEquals(a, b);//fail
		//Assert.assertNotEquals(a, b);//pass
		
		//Assert.assertTrue(false);//fail
		//Assert.assertTrue(true);//pass
		//Assert.assertTrue(5 == 5);//pass
		//Assert.fail();//fail
		
		String s = null;
		//Assert.assertNull(s);//pass
		Assert.assertNotNull(s);//fail
	}
}
